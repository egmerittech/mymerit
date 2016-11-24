package com.github.egmerittech.web.controller.auth;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.egmerittech.model.Family;
import com.github.egmerittech.model.FamilyMember;
import com.github.egmerittech.model.User;
import com.github.egmerittech.web.security.JpaUser;

/**
 * @author Greg Baker
 */
@Controller
@RequestMapping("/auth/")
public class FamilyMemberController {

	@GetMapping("/view-member/{id}")
	public String doit(Authentication authentication, ModelMap model, @PathVariable Long id) {
		final JpaUser jpaUser = (JpaUser) authentication.getPrincipal();
		final User user = jpaUser.getUser();

		final Optional<Family> family = Optional.of(user.getFamilyMember().getFamily());
		getFamilyMember(id, family).ifPresent(familyMember -> model.put("familyMember", familyMember));

		return "/auth/view-member";
	}


	protected Optional<FamilyMember> getFamilyMember(Long id, Optional<Family> family) {
		return family
				.map(x -> x.getFamilyMembers())
				.map(x -> x.stream())
				.flatMap(x -> {
					return x.filter(y -> id.equals(y.getId())).findFirst();
				});
	}

}
