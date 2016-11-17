package com.github.egmerittech.model;

import javax.persistence.Entity;

/**
 * @author Greg Baker
 */
@Entity
@SuppressWarnings("serial")
public class Task extends AbstractEntity {

	protected String name;


	protected String description;


	protected Double reward;


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


	public Double getReward() {
		return reward;
	}


	public void setReward(Double reward) {
		this.reward = reward;
	}

}
