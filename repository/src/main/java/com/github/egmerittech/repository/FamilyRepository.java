package com.github.egmerittech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.egmerittech.model.Family;

/**
 * @author Greg Baker
 */
public interface FamilyRepository extends JpaRepository<Family, Long> {

	/* intentionally left blank */

}
