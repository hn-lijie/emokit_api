package com.xinktech.api.config;

import com.xinktech.api.interceptor.LoggerInterceptor;
import com.xinktech.api.interceptor.UserAuthorizationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggerInterceptor());
        registry.addInterceptor(userAuthorizationInterceptor());
    }

    @Bean
    LoggerInterceptor loggerInterceptor() {
        return new LoggerInterceptor();
    }

    @Bean
    UserAuthorizationInterceptor userAuthorizationInterceptor() {
        return new UserAuthorizationInterceptor();
    }
}
