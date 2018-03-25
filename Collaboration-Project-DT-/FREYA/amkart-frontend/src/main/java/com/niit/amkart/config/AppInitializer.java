package com.niit.amkart.config;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {
	private String TMP_FOLDER="/tmp"; 
	 private int MAX_UPLOAD_SIZE = 5*1024*1024; 
     
	    public void onStartup(ServletContext container) throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		//ctx.register(WebSecurityConfig.class);
		ctx.setServletContext(container);
		 container.addListener(new ContextLoaderListener(ctx));
		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher",new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		  
        MultipartConfigElement multipartConfigElement=new MultipartConfigElement(TMP_FOLDER,MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE/2);
         
        servlet.setMultipartConfig(multipartConfigElement);
		servlet.addMapping("/");
		   
        
         
     
	  }

}