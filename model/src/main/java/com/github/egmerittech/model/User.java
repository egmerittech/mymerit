package com.github.egmerittech.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

/**
 * @author Greg Baker
 */
@Entity
@SuppressWarnings("serial")
public class User extends AbstractEntity {

	protected String firstname;


	protected String lastname;


	@Column(unique = true, nullable = false)
	protected String username;

	@Column(nullable = false)
	protected String password;


	@Transient
	protected String passwordMatch;


	@Column(nullable = false)
	protected Boolean enabled;


	@Column(nullable = false)
	protected Boolean validated;


	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	protected Set<Role> roles;


	@Override
	@PrePersist
	public void prePersist() {
		super.prePersist();
		enabled = Boolean.TRUE;
		validated = Boolean.FALSE;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


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


	public String getPasswordMatch() {
		return passwordMatch;
	}


	public void setPasswordMatch(String passwordMatch) {
		this.passwordMatch = passwordMatch;
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


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
