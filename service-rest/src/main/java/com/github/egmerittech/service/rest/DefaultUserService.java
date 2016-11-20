package com.github.egmerittech.service.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.egmerittech.model.User;
import com.github.egmerittech.repository.UserRepository;
import com.github.egmerittech.service.RoleService;
import com.github.egmerittech.service.UserService;

/**
 * @author Greg Baker
 */
@Controller
@RequestMapping("/users")
@ExposesResourceFor(User.class)
public class DefaultUserService implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultUserService.class);


	protected final EntityLinks entityLinks;


	protected final RoleService roleService;


	protected final UserRepository userRepository;


	public DefaultUserService(UserRepository userRepository, RoleService roleService, EntityLinks entityLinks) {
		this.userRepository = userRepository;
		this.roleService = roleService;
		this.entityLinks = entityLinks;
	}


	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<Resources<User>> getUsers() {
		final Resources<User> resources = new Resources<>(userRepository.findAll());
		resources.add(entityLinks.linkToCollectionResource(User.class));
		return new ResponseEntity<>(resources, HttpStatus.OK);
	}


	@Override
	public User create(String username, String password) {
		final User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRoles(roleService.getDefaultRoles());

		LOGGER.debug("Saving user [{}] to data store", username);
		final User savedUser = userRepository.save(user);
		LOGGER.debug("Successfully saved user; username=[{}], id=[{}]", username, savedUser.getId());

		return user;
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
