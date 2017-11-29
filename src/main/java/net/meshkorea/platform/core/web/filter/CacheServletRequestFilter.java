package net.meshkorea.platform.core.web.filter;

import lombok.extern.slf4j.Slf4j;
import net.meshkorea.platform.core.web.servlet.MultiReadHttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
public class CacheServletRequestFilter extends OncePerRequestFilter {

    private String[] excludeMethods;
    private String[] excludeUrlPatterns;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        // Wrap the request in order to read the InputStream multiple times
        MultiReadHttpServletRequest multiReadRequest = new MultiReadHttpServletRequest((HttpServletRequest) request);

        /*
         * When I pass the wrapped request through the filter chain, the rest of the filters
         * and request handlers may read the cached InputStream
         */
        chain.doFilter(multiReadRequest, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        boolean match = false;
        if (hasExcludeMethods()) {
            String method = request.getMethod();
            match = Arrays.stream(this.excludeMethods)
                .anyMatch(m -> StringUtils.equalsIgnoreCase(m, method));
        }
        if (!match && hasExcludePatterns()) {
            AntPathMatcher antPathMatcher = new AntPathMatcher();
            String path = request.getServletPath();
            match = Arrays.stream(this.excludeUrlPatterns)
                .anyMatch(p -> antPathMatcher.match(p, path));
        }
        return match;
    }

    public void setExcludeMethods(String... excludeMethods) {
        this.excludeMethods = excludeMethods;
    }

    public void setExcludePatterns(String... excludePatterns) {
        this.excludeUrlPatterns = excludePatterns;
    }

    private boolean hasExcludePatterns() {
        return this.excludeUrlPatterns != null && this.excludeUrlPatterns.length > 0;
    }

    private boolean hasExcludeMethods() {
        return this.excludeMethods != null && this.excludeMethods.length > 0;
    }

}
