package com.github.egmerittech.web.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Greg Baker
 */
@Controller
public class AuthenticationController {

	@GetMapping("/auth/sign-in")
	public String signIn(ModelMap modelMap) {
		modelMap.put("command", new Form());
		return "/auth/sign-in";
	}


	public static class Form {

		private String email;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

	}
}
