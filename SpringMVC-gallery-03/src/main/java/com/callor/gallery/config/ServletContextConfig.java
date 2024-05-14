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
@EnableWebMvc  //  Spring MVC 구성을 활성화하는 데 사용

@ComponentScan(basePackages = {"com.callor.gallery.controller"})
public class ServletContextConfig implements WebMvcConfigurer{

	// resource-mapping 을 대신하는 코드
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addResourceHandler("/static/**")
			.addResourceLocations("/static/");
		
		registry.addResourceHandler("/css/**")
		.addResourceLocations("/static/css/"); // css를 요청하면 static의 css로 요청해라
		
		registry.addResourceHandler("/js/**")
		.addResourceLocations("/static/js/");
		
		registry.addResourceHandler("/images/**") // 이미지라는 이름으로 접근
			.addResourceLocations("file:///app/upload/", "/static/images/"); //이미지 업로드할 c드라이브
									// 여기서 찾고, 없으면 여기서 찾아라
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
