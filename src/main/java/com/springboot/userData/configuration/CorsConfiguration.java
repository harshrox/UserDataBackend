package com.springboot.userData.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")  // Access allowed from any origin/domain
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allowed HTTP methods
                .allowedHeaders("*");  // Allowed headers
    }
}
