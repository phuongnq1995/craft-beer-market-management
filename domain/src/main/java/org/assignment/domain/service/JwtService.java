package org.assignment.domain.service;

import org.assignment.domain.entity.Oauth;

/**
 * @author Phuongnq
 * JwtService
 */
public interface JwtService {

	/**
	 * generateTokenLogin
	 * @param oauth
	 * @return String
	 */
	public String generateTokenLogin(Oauth oauth);

}
