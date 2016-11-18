package com.github.egmerittech.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.github.egmerittech.model.User;
import com.github.egmerittech.repository.UserRepository;

/**
 * @author Greg Baker
 */
public class DefaultUserService implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultUserService.class);


	protected final PasswordEncoder passwordEncoder;


	protected final UserRepository userRepository;


	public DefaultUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}


	@Override
	public void create(String username, String password) {
		final User user = new User();
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));

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
