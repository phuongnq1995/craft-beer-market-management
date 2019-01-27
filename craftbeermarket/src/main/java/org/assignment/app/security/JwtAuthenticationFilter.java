package org.assignment.app.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.assignment.domain.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

/**
 * @author Phuongnq
 * JwtAuthenticationFilter
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final static String TOKEN_HEADER = "authorization";

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserDetailsService userService;

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String authToken = httpRequest.getHeader(TOKEN_HEADER);
		if (jwtService.validateTokenLogin(authToken)) {
			String username = jwtService.getUsernameFromToken(authToken);
			UserDetails userDetail = userService.loadUserByUsername(username);
			if (userDetail != null) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail,
						null, userDetail.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		chain.doFilter(request, response);
	}

}
