package com.github.egmerittech.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * @author Greg Baker
 */
@Entity
@SuppressWarnings("serial")
public class Role extends AbstractEntity {

	@Column(unique = true, nullable = false)
	protected String name;


	@ManyToMany(mappedBy = "roles")
	protected List<User> users;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUser(List<User> users) {
		this.users = users;
	}

}
