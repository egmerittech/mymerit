package com.github.egmerittech.model;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author Greg Baker
 */
@Entity
@SuppressWarnings("serial")
public class Family extends AbstractEntity {

	protected String familyName;


	@OneToMany(mappedBy = "id")
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
