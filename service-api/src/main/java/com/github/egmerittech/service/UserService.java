package com.github.egmerittech.service;

import com.github.egmerittech.model.User;

/**
 * @author Greg Baker
 */
public interface UserService {

	User create(String username, String password);


	boolean exists(String username);


	User read(String username);

}
