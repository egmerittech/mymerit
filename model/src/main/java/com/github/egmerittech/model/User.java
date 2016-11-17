package com.github.egmerittech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Greg Baker
 */
@Entity
@Table(name = "users")
@SuppressWarnings("serial")
public class User extends AbstractEntity {

	@Column(unique = true, nullable = false)
	protected String username;

	@Column(nullable = false)
	protected String password;


	@Column(nullable = false)
	protected Boolean enabled = Boolean.TRUE;


	protected Boolean validated = Boolean.FALSE;



	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public Boolean getValidated() {
		return validated;
	}


	public void setValidated(Boolean validated) {
		this.validated = validated;
	}

}
