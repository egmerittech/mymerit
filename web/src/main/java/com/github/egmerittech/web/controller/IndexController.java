package com.github.egmerittech.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Greg Baker
 */
@Controller
public class IndexController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

}
