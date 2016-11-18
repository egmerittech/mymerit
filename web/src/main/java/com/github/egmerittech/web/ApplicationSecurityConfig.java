	package com.github.egmerittech.web;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.github.egmerittech.repository.UserRepository;
import com.github.egmerittech.web.security.JpaUserDetailsService;

/**
 * @author Greg Baker
 */
@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment environment;


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
		web
			.ignoring()
				.antMatchers("/assets/**")
				.antMatchers("/h2-console/**");
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
				.failureUrl("/auth/sign-in?status=autherror")
				.permitAll()
				.and()

			.logout()
				.logoutUrl("/auth/sign-out")
				.logoutSuccessUrl("/auth/sign-in?status=signedout")
				.permitAll()
				.and()

			.rememberMe()
				.tokenRepository(persistentTokenRepository(null))
				.tokenValiditySeconds(environment.getProperty("mymerit.security.tokenvalidityseconds", Integer.class))
				.and()

			.exceptionHandling()
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

}
