package com.github.egmerittech.web.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Greg Baker
 */
@Controller
public class AuthenticationController {

	@GetMapping("/auth/sign-up")
	public String signUpForm(@ModelAttribute SignupBean signupBean) {
		return "/auth/sign-up";
	}


	@PostMapping("/auth/sign-up")
	public String signUp(@ModelAttribute SignupBean signupBean) {
		return "redirect:/auth/sign-in";
	}


	@GetMapping("/auth/sign-in")
	public String signIn(ModelMap modelMap) {
		return "/auth/sign-in";
	}

}
