package com.example.Bookstore.config;

import com.example.Bookstore.util.TokenUtillity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebConfig implements WebMvcConfigurer {
    public void addCrosMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("https://localhost:4200/")
                .allowedMethods("GET","POST","PUT","DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    @Bean
    public TokenUtillity tokenUtillity() {

        return new TokenUtillity();
    }
}