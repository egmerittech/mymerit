package com.github.egmerittech.model;

import javax.persistence.Entity;

/**
 * @author Greg Baker
 */
@Entity
public class Account extends AbstractEntity {

	protected Double amount;


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
