package com.github.egmerittech.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@SuppressWarnings("serial")
public class EmailToken extends AbstractEntity {

	protected String token;


	@OneToOne
	protected User user;


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
