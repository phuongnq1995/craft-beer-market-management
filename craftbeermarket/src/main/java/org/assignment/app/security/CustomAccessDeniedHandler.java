package org.assignment.app.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.assignment.common.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Phuongnq
 * CustomAccessDeniedHandler
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	/* (non-Javadoc)
	 * @see org.springframework.security.web.access.AccessDeniedHandler#handle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.access.AccessDeniedException)
	 */
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exc)
			throws IOException, ServletException {
		response.setStatus(HttpStatus.FORBIDDEN.value());
		response.getWriter().write(getMessageResult());
	}

	/**
	 * getMessageResult
	 * @return messageResult
	 * @throws JsonProcessingException
	 */
	private String getMessageResult() throws JsonProcessingException {
		HttpResponse error = new HttpResponse("Access Denied !", HttpStatus.FORBIDDEN);
		return new ObjectMapper().writeValueAsString(error);
	}
}
