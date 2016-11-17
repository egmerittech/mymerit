package com.github.egmerittech.model;

import javax.persistence.Entity;

/**
 * @author Greg Baker
 */
@Entity
@SuppressWarnings("serial")
public class Prize extends AbstractEntity {

	protected String name;


	protected String description;


	protected Double cost;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getCost() {
		return cost;
	}


	public void setCost(Double cost) {
		this.cost = cost;
	}

}
