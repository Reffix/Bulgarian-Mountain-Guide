package com.mountain.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/hotels/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
        registry.addMapping("/cottages/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
        registry.addMapping("/fauna/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
        registry.addMapping("/attractions/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
        registry.addMapping("/flora/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
        registry.addMapping("/landmarks/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
        registry.addMapping("/routes/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
        registry.addMapping("/users/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
    }
}
