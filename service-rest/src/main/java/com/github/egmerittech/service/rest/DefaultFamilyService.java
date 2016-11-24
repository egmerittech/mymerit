package com.github.egmerittech.service.rest;

import com.github.egmerittech.model.Family;
import com.github.egmerittech.model.User;
import com.github.egmerittech.repository.FamilyRepository;
import com.github.egmerittech.service.FamilyService;

/**
 * @author Greg Baker
 */
public class DefaultFamilyService implements FamilyService {

	protected FamilyRepository familyRepository;


	public DefaultFamilyService(FamilyRepository familyRepository) {
		this.familyRepository = familyRepository;
	}


	@Override
	public Family getFamily(User user) {
		throw new UnsupportedOperationException("not yet implemented");
	}

}
