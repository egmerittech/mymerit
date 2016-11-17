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
public class User extends AbstractEntity {

	@Column(unique = true, nullable = false)
	protected String username;

	@Column(nullable = false)
	protected String password;


	@Column(nullable = false)
	protected Boolean enabled = Boolean.TRUE;


	@Column(nullable = false)
	protected Boolean validated = Boolean.FALSE;


	@ManyToMany
	protected List<Role> roles;


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


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
