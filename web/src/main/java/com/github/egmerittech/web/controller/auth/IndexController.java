package com.github.egmerittech.web.controller.auth;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Greg Baker
 */
@Controller("/auth")
public class IndexController {

	@GetMapping("/auth")
	public String index(Principal principal) {
		return "/auth/index";
	}

}
