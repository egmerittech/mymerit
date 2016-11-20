package com.github.egmerittech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.egmerittech.model.EmailToken;

/**
 * @author Greg Baker
 */
public interface EmailTokenRepository extends JpaRepository<EmailToken, Long> {

	/* intentionally left blank */

}
