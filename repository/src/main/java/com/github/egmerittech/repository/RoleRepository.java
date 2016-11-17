package com.github.egmerittech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.egmerittech.model.Role;

/**
 * @author Greg Baker
 */
public interface RoleRepository extends JpaRepository<Role, Long>{

	/* intentionally left blank */

}
