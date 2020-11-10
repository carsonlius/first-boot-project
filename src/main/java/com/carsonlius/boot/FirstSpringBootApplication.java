package com.carsonlius.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.carsonlius.boot.mapper") // 开启扫描包和子包
@ServletComponentScan(basePackages = {"com.carsonlius.boot.servlet","com.carsonlius.boot.filter"}) // 开启servlet/过滤器的扫描
public class FirstSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootApplication.class, args);
	}

}
