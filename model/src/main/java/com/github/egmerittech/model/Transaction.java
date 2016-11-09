package com.github.egmerittech.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Greg Baker
 */
@Entity
public class Transaction extends AbstractEntity {

	@ManyToOne
	protected FamilyMember familyMember;


	public FamilyMember getFamilyMember() {
		return familyMember;
	}


	public void setFamilyMember(FamilyMember familyMember) {
		this.familyMember = familyMember;
	}

}
