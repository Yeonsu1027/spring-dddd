package com.callor.gallery.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * web.xml 의 설정을 대신할 클래스 파일
 * */
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		
		return new Class[]{
				RootContextConfig.class,
				MyBatisContextConfig.class // 여긴 * 안됨.
				}; //클래스를 통째로가져와서 변수에담는다 : 클래스 >>참조<<
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletContextConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encKor = new CharacterEncodingFilter(); //한글깨짐방지
		encKor.setEncoding("UTF-8");
		encKor.setForceEncoding(true);
		return new Filter[] { encKor };
	}
	
	
	
	
	

}
