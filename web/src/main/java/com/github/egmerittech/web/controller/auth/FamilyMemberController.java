package com.github.egmerittech.web.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Greg Baker
 */
@Controller
@RequestMapping("/auth/")
public class FamilyMemberController {

	@GetMapping("/view-member/{id}")
	public String doit(@PathVariable Long id) {
		return "/auth/view-member";
	}

}
