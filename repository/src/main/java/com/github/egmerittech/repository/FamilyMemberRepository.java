package com.github.egmerittech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.egmerittech.model.FamilyMember;

/**
 * @author Greg Baker
 */
public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long> {

	/* intentionally left blank*/

}
