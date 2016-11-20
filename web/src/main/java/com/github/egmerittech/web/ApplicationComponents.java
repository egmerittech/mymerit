package com.github.egmerittech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.env.Environment;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.mail.MailSender;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.HandlerInterceptor;

import com.github.egmerittech.repository.EmailTokenRepository;
import com.github.egmerittech.web.event.SignupEvent;
import com.github.egmerittech.web.event.SignupEventListener;
import com.github.egmerittech.web.interceptor.SecurityPrincipalInterceptor;

/**
 * @author Greg Baker
 */
@EnableWebSecurity
@EntityScan({ "com.github.egmerittech.model" })
@Import({ com.github.egmerittech.repository.Module.class })
public class ApplicationComponents {

	@Autowired
	private Environment environment;


	@Autowired // this must be autowired to avoid circular dependencies
	private EmailTokenRepository emailTokenRepository;


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Bean
	public HandlerInterceptor securityPrincipalInterceptor() {
		return new SecurityPrincipalInterceptor();
	}


	@Bean
	public ApplicationEventMulticaster applicationEventMulticaster() {
		final SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
		eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
		return eventMulticaster;
	}


	@Bean
	@ConditionalOnProperty("mymerit.sendverifcationemail")
	public ApplicationListener<SignupEvent> signupEventListener(MailSender mailSender) {
		final SignupEventListener eventListener = new SignupEventListener(mailSender, emailTokenRepository);
		eventListener.setExpiryTimeDays(environment.getProperty("mymerit.emailtoken.expirytimedays", Integer.class));
		return eventListener;
	}

}
