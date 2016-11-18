package com.github.egmerittech.web.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.github.egmerittech.model.Role;
import com.github.egmerittech.model.User;

/**
 * @author Greg Baker
 */
@SuppressWarnings("serial")
public class JpaUser extends org.springframework.security.core.userdetails.User {

	final String firstname;


	final String lastname;


	public JpaUser(User user) {
		super(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, getAuthorities(user));
		this.firstname = user.getFirstname();
		this.lastname = user.getLastname();
	}


	public String getFirstname() {
		return firstname;
	}


	public String getLastname() {
		return lastname;
	}


	private static Set<GrantedAuthority> getAuthorities(User user) {
		final Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		for (final Role role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}

		return authorities;
	}

}
