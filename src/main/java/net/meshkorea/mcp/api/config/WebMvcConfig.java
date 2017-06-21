package net.meshkorea.mcp.api.config;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by reverof on 2017. 4. 10..
 */
@Component
@EnableJpaAuditing
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedMethods("OPTIONS", "GET", "HEAD", "POST", "PUT")
            .allowedHeaders("x-requested-with", "authorization", "content-type")
            .maxAge(3600);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageableHandlerMethodArgumentResolver pageableHandlerMethodArgumentResolver = new PageableHandlerMethodArgumentResolver();
        pageableHandlerMethodArgumentResolver.setOneIndexedParameters(true);
        argumentResolvers.add(pageableHandlerMethodArgumentResolver);
    }

}
