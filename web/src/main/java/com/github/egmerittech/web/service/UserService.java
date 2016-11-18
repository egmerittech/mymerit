package com.github.egmerittech.web.service;

/**
 * @author Greg Baker
 */
public interface UserService {

	void create(String username, String password);


	boolean exists(String username);

}
