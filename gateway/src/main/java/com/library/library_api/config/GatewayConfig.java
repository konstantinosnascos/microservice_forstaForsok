package com.library.library_api.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {

        return builder.routes()

                .route("book-service", r -> r
                        .path("/api/v1/books/**")
                        .uri("http://localhost:8081")
                )

                .route("loan-service", r -> r
                        .path("/api/v1/loans/**")
                        .uri("http://localhost:8082")
                )

                .route("author-service", r -> r
                        .path("/api/v1/authors/**")
                        .uri("http://localhost:8083")
                )

                .build();
    }
}