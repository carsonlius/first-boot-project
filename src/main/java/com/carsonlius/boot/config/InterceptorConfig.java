package com.carsonlius.boot.config;

import com.carsonlius.boot.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 定义为配置类
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] patterns = {
                "/**"
        };
        String[] excludePatterns = {
                "/errorJsp",
                "/login",
        };

        registry.addInterceptor(new LogInterceptor())
                .addPathPatterns(patterns)
                .excludePathPatterns(excludePatterns);
    }
}
