package com.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("configuration started..");
		//Registering the class that incorporates the annotated DispatcherServlet configuration of spring
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		//context.register(WebAppConfig.class);
		context.register(MvcConfig.class);
		

		//Adding the listener for the rootContext, Manage the lifecycle of the root application context
		servletContext.addListener(new ContextLoaderListener(context));

		//Registering the dispatcher servlet mappings.
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		System.out.println("configuration end..");
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}
