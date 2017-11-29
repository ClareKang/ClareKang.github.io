package net.meshkorea.mcp.api.config;

import lombok.RequiredArgsConstructor;
import net.meshkorea.mcp.api.config.interceptor.AuditLogInterceptor;
import net.meshkorea.mcp.api.config.interceptor.AuditLogProperties;
import net.meshkorea.platform.core.web.filter.CacheServletRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;
import java.util.List;

/**
 * Created by reverof on 2017. 4. 10..
 */
@Configuration
@DependsOn({
    "auditLogInterceptor"
})
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private final AuditLogInterceptor auditLogInterceptor;

    private final AuditLogProperties auditLogProperties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedMethods("OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE")
            .allowedHeaders("Content-Type", "Access-Control-Allow-Origin", "Access-Control-Allow-Headers", "Authorization", "X-Requested-With", "requestId", "Correlation-Id")
            .exposedHeaders("Content-Disposition")
            .maxAge(3600);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageableHandlerMethodArgumentResolver pageableHandlerMethodArgumentResolver = new PageableHandlerMethodArgumentResolver();
        pageableHandlerMethodArgumentResolver.setOneIndexedParameters(true);
        argumentResolvers.add(pageableHandlerMethodArgumentResolver);
    }

    @Bean
    public FilterRegistrationBean cacheServletRequestFilter() {
        CacheServletRequestFilter cacheServletRequestFilter = new CacheServletRequestFilter();
        cacheServletRequestFilter.setExcludeMethods(auditLogProperties.getExcludeMethodArray());
        cacheServletRequestFilter.setExcludePatterns(auditLogProperties.getExcludePatternArray());

        FilterRegistrationBean registrationBean = new FilterRegistrationBean(cacheServletRequestFilter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Integer.MAX_VALUE);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean securityFilterChain(@Qualifier(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME) Filter securityFilter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(securityFilter);
        registration.setOrder(Integer.MAX_VALUE - 1);
        registration.setName(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME);
        return registration;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(auditLogInterceptor)
            .addPathPatterns(auditLogProperties.getIncludePatternArray())
            .excludePathPatterns(auditLogProperties.getExcludePatternArray());
    }

}
