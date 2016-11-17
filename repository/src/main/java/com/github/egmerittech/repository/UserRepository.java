package com.github.egmerittech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.github.egmerittech.model.User;

/**
 * @author Greg Baker
 */
public interface UserRepository extends CrudRepository<User, Long>, QueryByExampleExecutor<User> {

	/* intentionally left blank */

}
