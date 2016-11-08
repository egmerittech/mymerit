package com.github.egmerittech.web.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Greg Baker
 */
@Controller
public class AuthenticationController {

	@GetMapping("/auth/sign-in")
	public String signIn() {
		return "auth/sign-in";
	}

}
