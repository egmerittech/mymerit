package com.github.egmerittech.web.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;

import com.github.egmerittech.model.Role;
import com.github.egmerittech.repository.RoleRepository;

/**
 * @author Greg Baker
 */
public class DefaultRoleService implements RoleService {

	protected Set<String> defaultRoleNames = Collections.emptySet();


	protected final RoleRepository roleRepository;


	public DefaultRoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}


	@Override
	@Cacheable("default-roles")
	public Set<Role> getDefaultRoles() {
		final Set<Role> roles = new HashSet<>();

		for (final String roleName : defaultRoleNames) {
			final Role probeRole = new Role();
			probeRole.setRole(roleName);

			final Role role = roleRepository.findOne(Example.of(probeRole));

			if (role != null) { roles.add(role); }
		}

		return roles;
	}


	public void setDefaultRoleNames(String ... defaultRoleNames) {
		this.defaultRoleNames = new HashSet<>();
		for (final String roleName : defaultRoleNames) {
			this.defaultRoleNames.add(roleName);
		}
	}

}
