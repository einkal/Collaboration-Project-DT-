package com.niit.freyamiddleware.config;

import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.niit.Freya.config.AppContextConfig;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		System.out.println("customizeRegistration");
		registration.setInitParameter("dispatchOptionsRequest", "true");
		registration.setAsyncSupported(true);
	}

	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		return new Class[]{WebResolver.class,AppContextConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() 
	{
		return  new String[] {"/"};
	}

}