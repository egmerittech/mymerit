package com.github.egmerittech.web.security.auth;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Greg Baker
 */
public class DefaultAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAuthenticationSuccessHandler.class);


	protected final ObjectMapper objectMapper = new ObjectMapper();


	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		if (request.getParameter("ajax") != null) {
			LOGGER.debug("Detected AJAX login failure");
			handleAjaxRequest(request, response, authentication);
			return;
		}
		else {
			LOGGER.debug("Detected non-AJAX login failure");
			super.onAuthenticationSuccess(request, response, authentication);
			return;
		}
	}


	private void handleAjaxRequest(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, JsonProcessingException {
		final String contextPath = request.getContextPath();
		final String successUrl = contextPath + "/";

		final Map<String, Object> map = new HashMap<>();
		map.put("success", true);
		map.put("successUrl", successUrl);

		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		response.setStatus(HttpServletResponse.SC_OK);

		response.getWriter().print(objectMapper.writeValueAsString(map));
		response.getWriter().flush();
	}

}
