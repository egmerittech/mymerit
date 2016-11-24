package com.github.egmerittech.web.security.auth;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.servlet.LocaleResolver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Greg Baker
 */
public class DefaultAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAuthenticationFailureHandler.class);


	protected final LocaleResolver localeResolver;


	protected final MessageSource messageSource;


	protected final ObjectMapper objectMapper = new ObjectMapper();


	public DefaultAuthenticationFailureHandler(MessageSource messageSource, LocaleResolver localeResolver) {
		this.messageSource = messageSource;
		this.localeResolver = localeResolver;
	}


	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		if (request.getParameter("ajax") != null) {
			LOGGER.debug("Detected AJAX login failure");
			handleAjaxRequest(request, response, exception);
			return;
		}
		else {
			LOGGER.debug("Detected non-AJAX login failure");
			super.onAuthenticationFailure(request, response, exception);
			return;
		}
	}


	private void handleAjaxRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, JsonProcessingException {
		final Locale locale = localeResolver.resolveLocale(request);
		final String errorMsg = messageSource.getMessage("signin.autherror", null, locale);

		final Map<String, Object> map = new HashMap<>();
		map.put("success", false);
		map.put("errorMsg", errorMsg);

		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		response.getWriter().print(objectMapper.writeValueAsString(map));
		response.getWriter().flush();
	}

}
