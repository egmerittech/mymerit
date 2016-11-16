package com.github.egmerittech.web;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

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
				.dataSource(dataSource)
				.passwordEncoder(new BCryptPasswordEncoder())
				.withUser("admin@localhost").password(new BCryptPasswordEncoder().encode("password")).roles("USER", "ADMIN");

	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()

			.headers()
				.cacheControl().disable()
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
				.antMatchers("/auth/sign-in").permitAll()
				.antMatchers("/auth/sign-out").permitAll()
				.antMatchers("/auth/sign-up").permitAll()
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
				.failureUrl("/auth/sign-in?error")
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

			.rememberMe()
				.tokenRepository(tokenRepository())
				.tokenValiditySeconds(1209600)
				.and()

			.exceptionHandling()
				.accessDeniedPage("/access-denied")
				.and();
	}


	@Bean
	public PersistentTokenRepository tokenRepository() {
		final JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		return tokenRepository;
	}

}
