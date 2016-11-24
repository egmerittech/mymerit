package com.github.egmerittech.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@SuppressWarnings("serial")
public class EmailToken extends AbstractEntity {

	@Column(unique = true, nullable = false)
	protected String token;


	@OneToOne(optional = false)
	protected User user;


	@Column(nullable = false)
	protected Calendar expiryDate;


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Calendar getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Calendar expiryDate) {
		this.expiryDate = expiryDate;
	}

}
