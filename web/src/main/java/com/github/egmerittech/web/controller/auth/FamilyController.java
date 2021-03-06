package com.github.egmerittech.web.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.egmerittech.model.Family;
import com.github.egmerittech.model.FamilyMember;
import com.github.egmerittech.model.User;
import com.github.egmerittech.service.UserService;
import com.github.egmerittech.web.security.JpaUser;

/**
 * @author Greg Baker
 */
@Controller
@RequestMapping("/auth/")
public class FamilyController {

	@Autowired
	private UserService userService;


	@GetMapping("/my-family")
	public String myFamily(Authentication authentication, ModelMap model) {
		final JpaUser jpaUser = (JpaUser) authentication.getPrincipal();
		final User user = userService.read(jpaUser.getUsername());
		final FamilyMember familyMember = user.getFamilyMember();
		final Family family = familyMember.getFamily();

		model.put("family", family);

		return "/auth/my-family";
	}

}
