package com.github.egmerittech.web;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Greg Baker
 */
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
				.dataSource(dataSource).withDefaultSchema()
				.passwordEncoder(new BCryptPasswordEncoder())
				.withUser("admin@localhost").password(new BCryptPasswordEncoder().encode("password")).roles("USER", "ADMIN");

	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()

			.headers()
				.frameOptions().disable()
				.and()

			// splash page should be unprotected
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.and()

			// static content should be unprotected
			.authorizeRequests()
				.antMatchers("/assets/**").permitAll()
				.antMatchers("/bootstrap/**").permitAll()
				.antMatchers("/h2-console/**").permitAll()
				.and()

			// resources requiring specific roles
			.authorizeRequests()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.and()

			// resources requiring authentication but no specific roles
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()

			.formLogin()
				.loginPage("/auth/sign-in")
//				.loginProcessingUrl("/sign-in")
				.failureUrl("/auth/sign-in?error")
//				.defaultSuccessUrl("/")
				.usernameParameter("email")
				.passwordParameter("password")
				.permitAll()
				.and()

			.logout()
				.deleteCookies("remember-me")
				.logoutUrl("/auth/sign-out")
				.logoutSuccessUrl("/auth/sign-in?logout")
				.permitAll()
				.and()

			.exceptionHandling()
				.accessDeniedPage("/access-denied")
				.and();
	}

}
