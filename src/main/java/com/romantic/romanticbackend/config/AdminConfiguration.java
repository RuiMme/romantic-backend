package com.romantic.romanticbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**","/","")
                .addResourceLocations("classpath:/public/")
                .addResourceLocations(new ClassPathResource("/public/index.html") {
                    @Override
                    public Resource createRelative(String relativePath){
                        return this;
                    }
                });
    }

}
