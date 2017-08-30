package net.meshkorea.mcp.api.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(excludePaths())
            .build()
            .ignoredParameterTypes(PagedResourcesAssembler.class, Pageable.class)
            .apiInfo(new ApiInfoBuilder()
                .title("Mesh Control Platform API")
                .version("1")
                .build())
            .securitySchemes(apiKeys())
            .securityContexts(securityContexts());
    }

    private List<ApiKey> apiKeys() {
        return Lists.newArrayList(
                new ApiKey("Bearer", "Authorization", "header"));
    }

    private List<SecurityContext> securityContexts() {
        return Lists.newArrayList(SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(internalPaths())
                .build());
    }

    /**
     * 제외할 URL 패턴
     *
     * @return
     */
    private Predicate<String> excludePaths() {
        return Predicates.not(Predicates.or(
            PathSelectors.regex("/v1/mms/send/excel.*"),
            PathSelectors.regex("/v1/mms/excel.*"),
            PathSelectors.regex("/v1/mms/sample.*"),
            PathSelectors.regex("/v1/intra/store/excel.*"),
            PathSelectors.regex("/v1/intra/subscription/excel.*"),
            PathSelectors.regex("/v1/intra/store_subscription/excel.*"),
            PathSelectors.regex("/v1/cert/mobile/identification.*")
        ));
    }

    private Predicate<String> internalPaths() {
        return Predicates.not(Predicates.or(
                PathSelectors.ant("/v1/common/**"),
                PathSelectors.ant("/v1/cert/mobile/**"),
                PathSelectors.ant("/v2/api-docs"),
                PathSelectors.ant("/swagger-ui.html"),
                PathSelectors.ant("/webjars/springfox-swagger-ui/**"),
                PathSelectors.ant("/swagger-resources/**")
        ));
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[0];
        return Lists.newArrayList(
                new SecurityReference("Bearer", authorizationScopes));

    }

}
