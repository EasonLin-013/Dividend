package com.example.getdividend;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@OpenAPIDefinition
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {

        Info info = new Info()
                .title("My Spring Boot API Document")
                .version("Ver. 1.0.1")
                .description("The document will list APIs we practice before.");
        return new OpenAPI().info(info);
    }
}

