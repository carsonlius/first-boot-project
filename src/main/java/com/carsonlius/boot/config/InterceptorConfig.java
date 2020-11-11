package com.carsonlius.boot.config;

import com.carsonlius.boot.interceptor.LogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 定义为配置类
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public LogInterceptor getLogInterceptor(){
        System.out.println("手动注入拦截器");
        return new LogInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] patterns = {
                "/log/*"
        };
        String[] excludePatterns = {
                "/errorJsp",
                "/login",
        };

        LogInterceptor logInterceptor = getLogInterceptor();
        registry.addInterceptor(logInterceptor)
                .addPathPatterns(patterns)
                .excludePathPatterns(excludePatterns);
    }
}
