package com.codekul.Spring11JuneBatch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableWebMvc
public class SwaggerConfig {
   // private static  final String DEFAULT_INCLUDE_PATTERN = "/api.*";
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
              //  .paths(regex(DEFAULT_INCLUDE_PATTERN))
                .build();
    }
}

/**
 * https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
 * http://localhost:8585/swagger-ui/index.html
 */