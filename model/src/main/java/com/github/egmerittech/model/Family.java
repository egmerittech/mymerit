package com.github.egmerittech.model;

import java.util.Collections;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * @author Greg Baker
 */
@Entity
@SuppressWarnings("serial")
public class Family extends AbstractEntity {

	@Column(nullable = false)
	protected String familyName;


	@OneToMany(mappedBy = "family", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<FamilyMember> familyMembers = Collections.emptySet();


	public String getFamilyName() {
		return familyName;
	}


	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}


	public Set<FamilyMember> getFamilyMembers() {
		return familyMembers;
	}


	public void setFamilyMembers(Set<FamilyMember> familyMembers) {
		this.familyMembers = familyMembers;
	}

}
