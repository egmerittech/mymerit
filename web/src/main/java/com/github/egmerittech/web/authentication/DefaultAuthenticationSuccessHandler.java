package com.github.egmerittech.web.authentication;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Greg Baker
 */
public class DefaultAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	protected final ObjectMapper objectMapper = new ObjectMapper();


	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		final String contextPath = request.getContextPath();

		final Map<String, Object> map = new HashMap<>();
		map.put("success", true);
		map.put("successUrl", contextPath + "/");

		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(HttpServletResponse.SC_OK);

		response.getWriter().print(objectMapper.writeValueAsString(map));
		response.getWriter().flush();
	}

}
