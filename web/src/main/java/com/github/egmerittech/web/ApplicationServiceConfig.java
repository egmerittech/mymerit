package com.github.egmerittech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.github.egmerittech.repository.UserRepository;
import com.github.egmerittech.web.service.DefaultUserService;
import com.github.egmerittech.web.service.UserService;

/**
 * @author Greg Baker
 */
@Configuration
public class ApplicationServiceConfig {

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Autowired
	private UserRepository userRepository;


	@Bean
	public UserService userService() {
		return new DefaultUserService(userRepository, passwordEncoder);
	}

}
