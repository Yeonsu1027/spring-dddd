package com.callor.gallery.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] {
				RootContextConfig.class,
				MyBatisContextConfig.class
				};
	
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {ServletContextConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		//return null;
		return new String[] {"/"};
	}

}
