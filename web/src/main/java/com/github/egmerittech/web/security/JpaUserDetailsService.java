package com.github.egmerittech.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.github.egmerittech.model.Role;
import com.github.egmerittech.model.User;
import com.github.egmerittech.repository.RoleRepository;
import com.github.egmerittech.repository.UserRepository;

/**
 * @author Greg Baker
 */
public class JpaUserDetailsService implements UserDetailsService {

	protected final UserRepository userRepository;


	protected RoleRepository roleRepository;


	@Autowired
	public JpaUserDetailsService(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final User exampleUser = new User();
		exampleUser.setUsername(username);

		Example<User> example = Example.of(exampleUser);
		final User user = userRepository.findOne(example);

		if (user == null) { return null; }

		final String password = user.getPassword();
		final List<GrantedAuthority> authorities = new ArrayList<>();

		for (final Role role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		return new org.springframework.security.core.userdetails.User(username, password, authorities);
	}

}
