package com.github.egmerittech.web.event;

import org.springframework.context.ApplicationEvent;

import com.github.egmerittech.model.User;

/**
 * @author Greg Baker
 */
@SuppressWarnings("serial")
public class SignupEvent extends ApplicationEvent {

	protected final User user;


	protected final String url;


	public SignupEvent(User user, String url) {
		super(user);
		this.user = user;
		this.url = url;
	}


	public User getUser() {
		return user;
	}


	public String getUrl() {
		return url;
	}

}
