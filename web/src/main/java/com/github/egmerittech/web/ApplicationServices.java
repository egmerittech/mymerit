package com.github.egmerittech.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.egmerittech.repository.FamilyRepository;
import com.github.egmerittech.repository.RoleRepository;
import com.github.egmerittech.repository.UserRepository;
import com.github.egmerittech.service.FamilyService;
import com.github.egmerittech.service.RoleService;
import com.github.egmerittech.service.UserService;
import com.github.egmerittech.service.rest.DefaultFamilyService;
import com.github.egmerittech.service.rest.DefaultRoleService;
import com.github.egmerittech.service.rest.DefaultUserService;

/**
 * @author Greg Baker
 */
@Configuration
public class ApplicationServices {

	@Bean
	public FamilyService familyService(FamilyRepository familyRepository) {
		return new DefaultFamilyService(familyRepository);
	}


	@Bean
	public RoleService roleService(RoleRepository roleRepository) {
		final DefaultRoleService roleService = new DefaultRoleService(roleRepository);
		roleService.setDefaultRoleNames("ROLE_USER");
		return roleService;
	}


	@Bean
	public UserService userService(UserRepository userRepository, RoleService roleService) {
		return new DefaultUserService(userRepository, roleService);
	}

}
