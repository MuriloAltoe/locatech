package com.locatech.locatech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI locatech() {
        return new OpenAPI().info(
                new Info().title("Locatech API")
                        .description("Projeto desenvolvido no curso SpringMVC")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0")));
    }

}
