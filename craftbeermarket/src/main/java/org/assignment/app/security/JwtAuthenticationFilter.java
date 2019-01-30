package org.assignment.app.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.assignment.common.HttpResponse;
import org.assignment.domain.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Phuongnq
 * JwtAuthenticationFilter
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserDetailsService userDetailsService;

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String authToken = httpRequest.getHeader(HttpHeaders.AUTHORIZATION);

		// Check valid token
		if (!jwtService.validateTokenLogin(authToken)) {
			setResponse(httpResponse);
			return;
		}
		setAuthentication(httpRequest);
		chain.doFilter(request, response);
	}

	/**
	 * Set Authentication
	 * @param httpRequest
	 */
	private void setAuthentication(HttpServletRequest httpRequest) {
		String authToken = httpRequest.getHeader(HttpHeaders.AUTHORIZATION);
		String username = jwtService.getUsernameFromToken(authToken);
		if(username == null) {
			return;
		}
		UserDetails userDetail = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail,
				null, userDetail.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	/**
	 * Message Result
	 * @throws IOException 
	 */
	private void setResponse(HttpServletResponse response) throws IOException {
		HttpResponse error = new HttpResponse("Missing token or token invalid !", HttpStatus.FORBIDDEN);
		response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
		response.setStatus(HttpStatus.FORBIDDEN.value());
		response.getWriter().write(new ObjectMapper().writeValueAsString(error));
	}

}
