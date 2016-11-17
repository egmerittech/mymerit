package com.github.egmerittech.web.security;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.github.egmerittech.model.Role;
import com.github.egmerittech.model.User;
import com.github.egmerittech.repository.UserRepository;

/**
 * @author Greg Baker
 */
public class JpaUserDetailsService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(JpaUserDetailsService.class);
	
	
	protected final UserRepository userRepository;


	@Autowired
	public JpaUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final User user = findUser(username);

		if (user == null) {
			LOGGER.debug("User with username [{}] not found", username);
			return null;
		}

		final String password = user.getPassword();
		final Set<GrantedAuthority> authorities = getAuthorities(user);

		return new org.springframework.security.core.userdetails.User(username, password, authorities);
	}

	
	protected User findUser(String username) {
		final User probe = new User();
		probe.setUsername(username);
		return userRepository.findOne(Example.of(probe));
	}

	
	protected Set<GrantedAuthority> getAuthorities(User user) {
		final Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		
		for (final Role role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}

		return authorities;
	}
	
}
