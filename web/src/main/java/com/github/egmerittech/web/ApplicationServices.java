package com.github.egmerittech.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.github.egmerittech.repository.RoleRepository;
import com.github.egmerittech.repository.UserRepository;
import com.github.egmerittech.web.service.DefaultRoleService;
import com.github.egmerittech.web.service.DefaultUserService;
import com.github.egmerittech.web.service.RoleService;
import com.github.egmerittech.web.service.UserService;

/**
 * @author Greg Baker
 */
@Configuration
public class ApplicationServices {

	@Bean
	public RoleService roleService(RoleRepository roleRepository) {
		final DefaultRoleService roleService = new DefaultRoleService(roleRepository);
		roleService.setDefaultRoleNames("ROLE_USER");
		return roleService;
	}


	@Bean
	public UserService userService(UserRepository userRepository, RoleService roleService, PasswordEncoder passwordEncoder) {
		return new DefaultUserService(userRepository, roleService, passwordEncoder);
	}

}
