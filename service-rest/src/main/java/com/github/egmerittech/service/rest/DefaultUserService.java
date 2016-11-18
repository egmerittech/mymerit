package com.github.egmerittech.service.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;

import com.github.egmerittech.model.User;
import com.github.egmerittech.repository.UserRepository;
import com.github.egmerittech.service.RoleService;
import com.github.egmerittech.service.UserService;

/**
 * @author Greg Baker
 */
public class DefaultUserService implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultUserService.class);


	protected final RoleService roleService;


	protected final UserRepository userRepository;


	public DefaultUserService(UserRepository userRepository, RoleService roleService) {
		this.userRepository = userRepository;
		this.roleService = roleService;
	}


	@Override
	public void create(String username, String password) {

		final User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRoles(roleService.getDefaultRoles());

		LOGGER.debug("Saving user [{}] to data store", username);
		final User savedUser = userRepository.save(user);
		LOGGER.debug("Successfully saved user; username=[{}], id=[{}]", username, savedUser.getId());
	}


	@Override
	public boolean exists(String username) {
		final User user = new User();
		user.setUsername(username);

		LOGGER.debug("Checking if user [{}] exists in data store", username);
		final boolean userExists = userRepository.exists(Example.of(user));
		LOGGER.debug("User[username={}].exists = {}", username, userExists);

		return userExists;
	}

}
