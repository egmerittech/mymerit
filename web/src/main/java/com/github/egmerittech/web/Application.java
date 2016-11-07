package com.github.egmerittech.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

/**
 * @author Greg Baker
 */
@SpringBootApplication
@EntityScan({ "com.github.egmerittech.model" })
@Import({ com.github.egmerittech.repository.Module.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
