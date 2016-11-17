package com.github.egmerittech.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Greg Baker
 */
@Entity
@Table(name = "persistent_logins")
@SuppressWarnings("serial")
public class PersistentLogin extends AbstractEntity {

	@Column(unique = true, nullable = false)
	protected String series;


	@ManyToOne(optional = false)
	@JoinColumn(name = "username", referencedColumnName = "username")
	protected User user;


	@Column(nullable = false)
	protected String token;


	@Column(nullable = false)
	protected Calendar lastUsed;


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getSeries() {
		return series;
	}


	public void setSeries(String series) {
		this.series = series;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public Calendar getLastUsed() {
		return lastUsed;
	}


	public void setLastUsed(Calendar lastUsed) {
		this.lastUsed = lastUsed;
	}

}
