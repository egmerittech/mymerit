	package com.github.egmerittech.web;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.web.servlet.LocaleResolver;

import com.github.egmerittech.repository.UserRepository;
import com.github.egmerittech.web.authentication.DefaultAuthenticationFailureHandler;
import com.github.egmerittech.web.authentication.DefaultAuthenticationSuccessHandler;
import com.github.egmerittech.web.security.JpaUserDetailsService;

/**
 * @author Greg Baker
 */
@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment environment;


	@Autowired
	private LocaleResolver localeResolver;


	@Autowired
	private MessageSource messageSource;


	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService(null))
			.passwordEncoder(passwordEncoder);
	}


	@Override
	public void configure(WebSecurity web) throws Exception {
		/* placeholder for future customization */
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()

			.headers()
				.cacheControl().disable()
				.frameOptions().disable()
				.and()

			// resources requiring specific roles
			.authorizeRequests()
				.antMatchers("/auth/**").hasRole("USER")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.and()

				// splash page should be unprotected
			.authorizeRequests()
				.anyRequest().permitAll()
				.and()

			.formLogin()
				.loginPage("/sign-in")
				.loginProcessingUrl("/sign-in")
				.successHandler(authenticationSuccessHandler())
				.failureHandler(authenticationFailureHandler())
//				.failureUrl("/sign-in?status=autherror")
				.and()

			.logout()
				.logoutUrl("/sign-out")
				.logoutSuccessUrl("/?status=signedout")
				.and()

			.rememberMe()
				.tokenRepository(persistentTokenRepository(null))
				.tokenValiditySeconds(environment.getProperty("mymerit.security.tokenvalidityseconds", Integer.class))
				.and()

			.exceptionHandling()
				// TODO - implement this
				.accessDeniedPage("/access-denied");
	}


	@Bean
	public UserDetailsService userDetailsService(UserRepository userRepository) {
		return new JpaUserDetailsService(userRepository);
	}


	@Bean
	public PersistentTokenRepository persistentTokenRepository(DataSource dataSource) {
		final JdbcTokenRepositoryImpl persistentTokenRepository = new JdbcTokenRepositoryImpl();
		persistentTokenRepository.setDataSource(dataSource);
		return persistentTokenRepository;
	}


	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new DefaultAuthenticationSuccessHandler();
	}


	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new DefaultAuthenticationFailureHandler(messageSource, localeResolver);
	}

}
