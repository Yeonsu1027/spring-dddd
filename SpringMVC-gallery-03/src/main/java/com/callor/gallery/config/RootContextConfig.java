package com.callor.gallery.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/*
 * @Configuration
 * 지금부터 이 클래스는 ContextBeanConfig 설정을 하는 클래스다 라는 선언 
 * */
@Configuration
public class RootContextConfig {
	
	@Bean(name = "multipartResolver") // 호환성위함 : bean의 이름을 이걸로 쓰겠다.
	public CommonsMultipartResolver getFileResolver() throws IOException {
		
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		
		// 한개의 파일 용량 제한하기
		resolver.setMaxUploadSizePerFile(1024 * 1024 * 2); //1k * 1k = 1m * 2 = 2m
		resolver.setMaxUploadSize(1024 * 1024 * 20);
		
		resolver.setUploadTempDir(new FileSystemResource("c:/temp")); // c 드라이브
		resolver.setDefaultEncoding("UTF-8"); // 파일 한글이름 깨짐 방지
		
		return resolver;
		
	}
	
	@Bean(name="ipLoadPath") // FileServiceImplV1 의 private final String upLoadPath;
	public String upLoadPath() {
		return "c:/app/upload"; // c드라이브
	}

}
