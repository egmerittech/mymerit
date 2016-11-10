package com.github.egmerittech.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Greg Baker
 */
@Controller
public class IndexController {

	@GetMapping("/")
	public String index(Principal principal) {
		if (principal == null) { return "redirect:auth/sign-up"; }

//		model.addAttribute("command", new SignupBean());
		return "/index";
	}

}
