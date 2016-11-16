package com.github.egmerittech.web.controller.auth;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
	public String signUp(@Valid SignupBean signupBean, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) { return "/auth/sign-up"; }
        return "redirect:/auth/sign-up";
	}


	@GetMapping("/auth/sign-in")
	public String signIn(ModelMap modelMap) {
		return "/auth/sign-in";
	}

}
