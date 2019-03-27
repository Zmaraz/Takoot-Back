package com.revature;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.revature.filters.DepthFilter;
import com.revature.filters.Filter;


@EnableWebMvc
@ComponentScan
@Configuration
public class ApplicationConfig implements WebMvcConfigurer, WebApplicationInitializer {
	
		 	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext container = new AnnotationConfigWebApplicationContext();
		container.register(ApplicationConfig.class);
		
		servletContext.addListener(new ContextLoaderListener(container));
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(container));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		

		servletContext.addFilter("filter", Filter.class).addMappingForServletNames(null, false, "DispatcherServlet");
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper om = new ObjectMapper().registerModule(new Hibernate5Module());
		SimpleFilterProvider depthFilters = new SimpleFilterProvider().addFilter("depth_1", new DepthFilter(1))
	            .addFilter("depth_2", new DepthFilter(2))
	            .addFilter("depth_3", new DepthFilter(3))
	            .addFilter("depth_4", new DepthFilter(4))
	            .addFilter("depth_5", new DepthFilter(5));
		om.setFilterProvider(depthFilters);
		
		return om;
	}
	
	
}
