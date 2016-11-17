package com.github.egmerittech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.egmerittech.model.User;

/**
 * @author Greg Baker
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/* intentionally left blank */

}
