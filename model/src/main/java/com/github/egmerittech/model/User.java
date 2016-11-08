package com.github.egmerittech.model;

import javax.persistence.MappedSuperclass;

/**
 * @author Greg Baker
 */
@MappedSuperclass
public abstract class User extends AbstractEntity {

	protected String name;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

}
