package com.udacity.vehicles.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        // Creates a new Docket object that has DocumentationType.SWAGGER_2.
        // This means that the API documentation will be in Swagger 2 format.
        return new Docket(DocumentationType.SWAGGER_2)
                // Creates an ApiSelectorBuilder, which controls the endpoints exposed by Swagger.
                .select()
                // Selects RequestHandlers with any RequestHandlerSelector. This means it will document all your APIs.
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                // Selects Paths with any PathSelector. This means it will document all paths of your APIs.
                .paths(PathSelectors.any())
                // Builds and returns a Docket given the configuration through the chain of method calls.
                .build()
                .useDefaultResponseMessages(false); // Disables use of default response messages. Default responses are 200, 201, 204, 207, 400, 401, 403, 404, and 500.
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Vehicle API",
                "This API returns a list of vehicle details.",
                "1.0",
                "",
                new Contact("Lee yuan Heng", "", "leeyuanheng16@gmail.com"),
                "", "", Collections.emptyList());
    }
}
