package com.github.egmerittech.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author Greg Baker
 */
@Entity
@SuppressWarnings("serial")
public class FamilyMember extends AbstractEntity {

	public enum Type { PARENT, CHILD }


	@OneToOne
	protected MeritAccount meritAccount;


	@ManyToOne
	protected Family family;


	@Enumerated(EnumType.STRING)
	protected FamilyMember.Type familyMemberType;


	protected String username;


	public Family getFamily() {
		return family;
	}


	public void setFamily(Family family) {
		this.family = family;
	}


	public FamilyMember.Type getFamilyMemberType() {
		return familyMemberType;
	}


	public void setFamilyMemberType(FamilyMember.Type familyMemberType) {
		this.familyMemberType = familyMemberType;
	}


	public MeritAccount getMeritAccount() {
		return meritAccount;
	}


	public void setMeritAccount(MeritAccount meritAccount) {
		this.meritAccount = meritAccount;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

}
