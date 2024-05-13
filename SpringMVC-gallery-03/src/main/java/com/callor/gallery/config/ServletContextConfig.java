package com.callor.gallery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//bean-context.xml 역할 수행
@Configuration // :xml 코드와 같은역할을 한다

// annotation-driven 를 대신하는 설정
@EnableWebMvc

@ComponentScan(basePackages = {"com.callor.gallery.controller"})
public class ServletContextConfig implements WebMvcConfigurer{

	// resource-mapping 을 대신하는 코드
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addResourceHandler("/static/**")
			.addResourceLocations("/static/");
		
		registry.addResourceHandler("/images/**") // 이미지라는 이름으로 접근
			.addResourceLocations("file:///app/upload/"); //이미지 업로드할 c드라이브
		
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
	// view 를 rendering 하는 bean 생성
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	

}
