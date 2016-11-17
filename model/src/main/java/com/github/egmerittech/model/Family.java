package com.github.egmerittech.model;

import java.util.List;

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
	protected List<FamilyMember> familyMembers;


	public String getFamilyName() {
		return familyName;
	}


	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}


	public List<FamilyMember> getFamilyMembers() {
		return familyMembers;
	}


	public void setFamilyMembers(List<FamilyMember> familyMembers) {
		this.familyMembers = familyMembers;
	}

}
