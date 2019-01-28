package org.assignment.domain.service;

import org.assignment.domain.model.TokenInfo;
import org.assignment.domain.util.TokenType;

/**
 * @author Phuongnq
 * JwtService
 */
public interface JwtService {

	/**
	 * generateTokenLogin
	 * @param name
	 * @return TokenInfo
	 */
	TokenInfo generateToken(String clientId, TokenType type);

	/**
	 * Validate token login
	 * @param token - the token
	 * @return true if valid else false
	 */
	boolean validateTokenLogin(String token);

	/**
	 * Get username from token
	 * @param token - the token
	 * @return username or null
	 */
	String getUsernameFromToken(String token);

	/**
	 * Check exist client
	 * @param clientId - The clientId
	 * @param clientSecret - the clientSecret
	 * @return true if exist else false
	 */
	public boolean checkExistClient(String clientId, String clientSecret);

}
