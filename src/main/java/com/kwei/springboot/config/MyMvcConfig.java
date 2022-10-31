package com.kwei.springboot.config;

import javax.servlet.http.HttpServlet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.kwei.springboot.component.MyLocaleResolver;
import com.kwei.springboot.servlet.MyServlet;

// 使用WebMvcConfigurerAdapter來擴展SpringMVC的功能
//@EnableWebMvc //對新版SpringBoot沒效果
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
	
	// 自定義Servlet
	public HttpServlet myServlet() {
		return new MyServlet();
	}
	
	// 語言國際化
	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// super.addViewControllers(registry);
		registry.addViewController("/tranquil").setViewName("success");
		registry.addViewController("/main.html").setViewName("dashboard");
//		registry.addViewController("/emp").setViewName("emp/add");
//		registry.addViewController("/").setViewName("index");
//		registry.addViewController("/index.html");
	}

	// 所有的WebMvcConfigurerAdapter都會生效
	@Bean
	public WebMvcConfigurerAdapter webMvcAdapter() {

		WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {

			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
//				registry.addViewController("/").setViewName("index");
//				registry.addViewController("/index.html").setViewName("index");
			}

//			// 註冊攔截器M1
//			@Override
//			public void addInterceptors(InterceptorRegistry registry) {
////				super.addInterceptors(registry);
//				// SpringBoot已經做好靜態資源映射
//				registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//									.excludePathPatterns("/index.html", "/", "/user/login");	
//			}
		};

		return adapter;
	}

	// 註冊攔截器M2
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new LoginHandlerInterceptor())
//								.addPathPatterns("/**")
//								.excludePathPatterns("/index.html", "/" , "/user/login");
//	}
	
	

	

}
