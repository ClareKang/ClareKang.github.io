package net.meshkorea.mcp.api.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by reverof on 2017. 4. 10..
 */
@Component
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedMethods("OPTIONS", "GET", "HEAD", "POST", "PUT")
            .allowedHeaders("x-requested-with", "authorization", "content-type")
            .maxAge(3600);
    }

//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        PageableHandlerMethodArgumentResolver pageableHandlerMethodArgumentResolver = new PageableHandlerMethodArgumentResolver();
//        pageableHandlerMethodArgumentResolver.setOneIndexedParameters(true);
//        argumentResolvers.add(pageableHandlerMethodArgumentResolver);
//    }
}
