package com.github.egmerittech.web;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.HandlerInterceptor;

import com.github.egmerittech.web.interceptor.SecurityPrincipalInterceptor;

/**
 * @author Greg Baker
 */
@EnableWebSecurity
@EntityScan({ "com.github.egmerittech.model" })
@Import({ com.github.egmerittech.repository.Module.class })
public class ApplicationComponents {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Bean
	public HandlerInterceptor securityPrincipalInterceptor() {
		return new SecurityPrincipalInterceptor();
	}

}
