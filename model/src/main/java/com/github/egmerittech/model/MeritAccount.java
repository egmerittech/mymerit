package com.github.egmerittech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author Greg Baker
 */
@Entity
@SuppressWarnings("serial")
public class MeritAccount extends AbstractEntity {

	@Column(nullable = false)
	protected Double balance;


	@OneToOne(optional = false)
	protected FamilyMember familyMember;


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public FamilyMember getFamilyMember() {
		return familyMember;
	}


	public void setFamilyMember(FamilyMember familyMember) {
		this.familyMember = familyMember;
	}

}
