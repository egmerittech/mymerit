package com.github.egmerittech.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author Greg Baker
 */
@Entity
@SuppressWarnings("serial")
public class FamilyMember extends AbstractEntity {

	public enum Type { PARENT, CHILD }


	@OneToOne(optional = false)
	protected User user;


	@OneToOne(mappedBy = "familyMember", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected MeritAccount meritAccount;


	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	protected Family family;


	@Enumerated(EnumType.STRING)
	protected FamilyMember.Type familyMemberType;


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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}
