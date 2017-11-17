package net.meshkorea.platform.core.web.filter;

import net.meshkorea.platform.core.web.servlet.MultiReadHttpServletRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CacheServletRequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // Wrap the request in order to read the InputStream multiple times
        MultiReadHttpServletRequest multiReadRequest = new MultiReadHttpServletRequest((HttpServletRequest) request);

        /*
         * When I pass the wrapped request through the filter chain, the rest of the filters
         * and request handlers may read the cached InputStream
         */
        chain.doFilter(multiReadRequest, response);
    }

}
