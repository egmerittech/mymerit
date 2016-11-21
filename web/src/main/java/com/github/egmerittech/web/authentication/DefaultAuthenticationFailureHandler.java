package com.github.egmerittech.web.authentication;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Greg Baker
 */
public class DefaultAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	protected final ObjectMapper objectMapper = new ObjectMapper();


	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		final Map<String, Object> map = new HashMap<>();
		map.put("success", false);

		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		response.getWriter().print(objectMapper.writeValueAsString(map));
		response.getWriter().flush();
	}

}
