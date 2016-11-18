package com.github.egmerittech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Greg Baker
 */
@Configuration
public class ApplicationWebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Autowired
	@Qualifier("securityPrincipalInterceptor")
	private HandlerInterceptor securityPrincipalInterceptor;


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(securityPrincipalInterceptor);
	}

}
