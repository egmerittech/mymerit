package com.github.egmerittech.model;

import javax.persistence.Entity;

/**
 * @author Greg Baker
 */
@Entity
public class MeritAccount extends AbstractEntity {

	protected Double balance;


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
