package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport{
	//资源映射
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO 自動生成されたメソッド・スタブ
		log.info("资源映射");
		registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
	}

}