package net.meshkorea.mcp.api.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(Predicates.not(excludePaths()))
            .build()
            .ignoredParameterTypes(PagedResourcesAssembler.class, Pageable.class)
            .apiInfo(new ApiInfoBuilder()
                .title("Mesh Control Platform API")
                .version("1")
                .build());
    }

    /**
     * 제외할 URL 패턴
     *
     * @return
     */
    private Predicate<String> excludePaths() {
        return Predicates.or(
            PathSelectors.regex("/v1/mms/send.*"),
            PathSelectors.regex("/v1/cert/mobile/identification.*")
        );
    }

}
