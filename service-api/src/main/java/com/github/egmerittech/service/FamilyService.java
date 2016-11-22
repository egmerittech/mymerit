package com.github.egmerittech.service;

import com.github.egmerittech.model.Family;
import com.github.egmerittech.model.User;

/**
 * @author Greg Baker
 */
public interface FamilyService {

	Family getFamily(User username);

}
