package com.library.library_api.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth

                    // swagger + h2 + docs
                    .requestMatchers(
                            "/h2-console/**",
                            "/v3/api-docs/**",
                            "/swagger-ui/**",
                            "/swagger-ui.html"
                    ).permitAll()

                    // ALLA endpoints öppna i microservice-läge
                    .requestMatchers("/api/v1/**").permitAll()

                    .anyRequest().authenticated()
            );

    // H2 console support
    http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

    return http.build();
}
}
