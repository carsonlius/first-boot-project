package com.carsonlius.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = "com.carsonlius.boot.mapper") // 开启扫描包和子包
@ServletComponentScan(basePackages = {"com.carsonlius.boot.servlet","com.carsonlius.boot.filter"}) // 开启servlet/过滤器的扫描
public class FirstSpringBootApplication extends SpringBootServletInitializer { // war需要继承SpringBootServletInitializer，重写configure
//public class FirstSpringBootApplication {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// 参数为springboot启动类，重新构建资源
		return builder.sources(FirstSpringBootApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootApplication.class, args);
	}

}
