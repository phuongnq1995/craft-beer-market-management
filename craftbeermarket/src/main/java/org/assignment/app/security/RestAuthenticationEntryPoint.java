package org.assignment.app.security;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.assignment.common.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Phuongnq
 * RestAuthenticationEntryPoint
 */
public final class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

	/* (non-Javadoc)
	 * @see org.springframework.security.web.AuthenticationEntryPoint#commence(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.AuthenticationException)
	 */
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		response.setStatus(HttpStatus.FORBIDDEN.value());
		response.getWriter().write(messageResult());
	}

	/**
	 * @return messageResult
	 * @throws JsonProcessingException
	 */
	private String messageResult() throws JsonProcessingException {
		ErrorResponse error = new ErrorResponse("Access Denied !", HttpStatus.FORBIDDEN);
		return new ObjectMapper().writeValueAsString(error);
	}
}
