package com.github.egmerittech.web.controller.auth;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 * @author Greg Baker
 */
public class SignupBean {

	@Email
	private String email;


	@Length(min = 6, max = 256)
	private String password;


	@Length(min = 6, max = 256)
	private String passwordMatch;


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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

}
