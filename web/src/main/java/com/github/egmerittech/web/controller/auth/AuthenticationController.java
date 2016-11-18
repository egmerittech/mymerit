package com.github.egmerittech.web.controller.auth;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.github.egmerittech.repository.UserRepository;
import com.github.egmerittech.web.service.UserService;

/**
 * @author Greg Baker
 */
@Controller
public class AuthenticationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);


	@Autowired
	protected PasswordEncoder passwordEncoder;


	@Autowired
	protected UserRepository userRepository;


	@Autowired
	protected UserService userService;


	@GetMapping("/auth/sign-up")
	public String signUpForm(@ModelAttribute SignupBean signupBean) {
		return "/auth/sign-up";
	}


	@PostMapping("/auth/sign-up")
	public String signUp(@Valid SignupBean signupBean, BindingResult bindingResult) {
		LOGGER.debug("Processing sign-up form submission");

		if (bindingResult.hasErrors()) {
			LOGGER.debug("Submitted sign-up form has {} errors: {}", bindingResult.getErrorCount(), bindingResult.getAllErrors());
			return "/auth/sign-up";
		}

		if (userService.exists(signupBean.getEmail()) == true) {
			LOGGER.debug("User [{}] already exists", signupBean.getEmail());
			bindingResult.reject("signupBean.email.alreadyregistered");
			return "/auth/sign-up";
		}

		LOGGER.debug("Submitted sign-up form passed validation checks, saving user...");
		userService.create(signupBean.getEmail(), signupBean.getPassword());

		LOGGER.debug("Redirecting user to /auth/sign-up");
		return "redirect:/auth/sign-up";
	}


	@GetMapping("/auth/sign-in")
	public String signIn(Model model, String status) {
		if ("autherror".equals(status) == true) { model.addAttribute("dangerAlert", "signin.autherror"); }
		if ("signedout".equals(status) == true) { model.addAttribute("successAlert", "signin.signedout"); }
		return "/auth/sign-in";
	}

}
