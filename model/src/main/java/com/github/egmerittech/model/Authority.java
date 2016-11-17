package com.github.egmerittech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Greg Baker
 */
@Entity
@Table(name = "authorities")
@SuppressWarnings("serial")
public class Authority extends AbstractEntity {

	@Column(nullable = false)
	protected String authority;


	@ManyToOne(optional = false)
	@JoinColumn(name = "username", referencedColumnName = "username")
	protected User user;


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
