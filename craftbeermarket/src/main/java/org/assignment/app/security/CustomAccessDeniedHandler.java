package org.assignment.app.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

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
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.getWriter().write("Access Denied !");
	}
}
