package org.assignment.domain.service;

/**
 * @author Phuongnq
 * JwtService
 */
public interface JwtService {

	/**
	 * generateTokenLogin
	 * @param user
	 * @return String
	 */
	String generateTokenLogin(String username);

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
	 * Check exist user
	 * @param username - The username
	 * @param passwordRaw - the password
	 * @return true if exist else false
	 */
	public boolean checkExistUser(String username, String passwordRaw);

}
