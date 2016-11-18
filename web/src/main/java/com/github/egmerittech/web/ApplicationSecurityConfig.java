package com.github.egmerittech.web;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.github.egmerittech.repository.UserRepository;
import com.github.egmerittech.web.security.JpaUserDetailsService;

/**
 * @author Greg Baker
 */
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService(null))
			.passwordEncoder(passwordEncoder());
	}


	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/assets/**");
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
				.failureUrl("/auth/sign-in?status=autherror")
				.usernameParameter("email")
				.passwordParameter("password")
				.permitAll()
				.and()

			.logout()
				.deleteCookies("remember-me")
				.logoutUrl("/auth/sign-out")
				.logoutSuccessUrl("/auth/sign-in?status=signedout")
				.permitAll()
				.and()

			.rememberMe()
				.tokenRepository(tokenRepository(null))
				.tokenValiditySeconds(1209600)
				.and()

			.exceptionHandling()
				.accessDeniedPage("/access-denied")
				.and();
	}


	@Bean
	public UserDetailsService userDetailsService(UserRepository userRepository) {
		return new JpaUserDetailsService(userRepository);
	}


	@Bean
	public PersistentTokenRepository tokenRepository(DataSource dataSource) {
		final JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		return tokenRepository;
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
