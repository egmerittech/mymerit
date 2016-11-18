package com.github.egmerittech.web.controller.auth;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.egmerittech.model.User;
import com.github.egmerittech.repository.UserRepository;
import com.github.egmerittech.web.service.UserService;

/**
 * @author Greg Baker
 */
@Controller
@RequestMapping("/auth")
public class AuthenticationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);


	@Autowired
	protected AuthenticationManager authenticationManager;


	@Autowired
	protected PasswordEncoder passwordEncoder;


	@Autowired
	protected UserRepository userRepository;


	@Autowired
	protected UserService userService;


	@GetMapping("/sign-up")
	public String signUpForm(@ModelAttribute User user) {
		return "/auth/sign-up";
	}


	@PostMapping("/sign-up")
	public String signUp(@Valid User user, BindingResult bindingResult, HttpServletRequest request) {
		LOGGER.debug("Processing sign-up form submission");

		if (bindingResult.hasErrors()) {
			LOGGER.debug("Submitted sign-up form has {} errors: {}", bindingResult.getErrorCount(), bindingResult.getAllErrors());
			return "/auth/sign-up";
		}

		if (userService.exists(user.getUsername()) == true) {
			LOGGER.debug("User [{}] already exists", user.getUsername());
			bindingResult.rejectValue("username", "signup.username.alreadyregistered");
			return "/auth/sign-up";
		}

		LOGGER.debug("Submitted sign-up form passed validation checks, saving user...");
		userService.create(user.getUsername(), user.getPassword());

		LOGGER.debug("User successfully created, performing post-creation sign-in...");
		authenticateUser(user, request);

		LOGGER.debug("Redirecting user to /");
		return "redirect:/";
	}


	@GetMapping("/sign-in")
	public String signIn(Model model, String status) {
		if ("autherror".equals(status) == true) { model.addAttribute("dangerAlert", "signin.autherror"); }
		if ("signedout".equals(status) == true) { model.addAttribute("successAlert", "signin.signedout"); }
		return "/auth/sign-in";
	}


	protected void authenticateUser(User user, HttpServletRequest request) {
		final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
		authenticationToken.setDetails(new WebAuthenticationDetails(request));
		final Authentication authentication = authenticationManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

}
