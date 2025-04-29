package com.mg.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/**") // todos los endpoints
                        .allowedOrigins("http://localhost:4300") // permitir el frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // métodos HTTP permitidos
                        .allowedHeaders("*") // permitir todos los headers
                        .allowCredentials(true); // si usás cookies o auth
            }
        };
    }
}