package com.github.egmerittech.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.egmerittech.model.User;

/**
 * @author Greg Baker
 */
public interface UserRepository extends CrudRepository<User, Long>{

	/* intentionally left blank */

}
