package com.kwei.springboot;

import java.util.Locale;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

@SpringBootApplication
public class SpringBoot04WebRestfulCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot04WebRestfulCrudApplication.class, args);
	}
	
	@Bean // 設置MyViewResolver為Bean, 且交由IOC容器管理, 且此Bean之id為方法名-myViewResolver.
	public ViewResolver myViewResolver() {
		return new MyViewResolver();
	}
	
	// 自定義ViewResolver
	private static class MyViewResolver implements ViewResolver {
		@Override
		public View resolveViewName(String viewName, Locale locale) throws Exception {
			return null;
		}
	}
	

}
