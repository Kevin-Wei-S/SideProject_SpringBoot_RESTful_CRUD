package com.kwei.springboot.config;

import java.util.List;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kwei.springboot.filter.MyFilter;
import com.kwei.springboot.listener.MyListener;
import com.kwei.springboot.servlet.MyServlet;

@Configuration
public class MyServerConfig {

	// 註冊三大組件
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean myServlet() {
		ServletRegistrationBean registrationBean = 
					new ServletRegistrationBean(new MyServlet(), "/myservlet");
		registrationBean.setLoadOnStartup(1);
		
		return registrationBean;
	}
	
	@Bean
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FilterRegistrationBean myFilter() {
		
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new MyFilter());
		registrationBean.setUrlPatterns(List.of("/myfilter", "/myservlet"));
		
		return registrationBean;
	}
	
	@Bean
	@SuppressWarnings("rawtypes")
	public ServletListenerRegistrationBean myListener() {
		
		ServletListenerRegistrationBean<MyListener> registrationBean = 
				new ServletListenerRegistrationBean<>(new MyListener());
		
		return registrationBean;
	}
	
	// 自定義嵌入式Servlet容器的相關配置M2
	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> myWebServerContainer() {

		WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> wsfc =
				new WebServerFactoryCustomizer<>(){
					@Override
					public void customize(ConfigurableServletWebServerFactory factory) {
						factory.setPort(8080);
						factory.setContextPath("/kwei");
					}
				};			
		return wsfc;
	}
	
}
