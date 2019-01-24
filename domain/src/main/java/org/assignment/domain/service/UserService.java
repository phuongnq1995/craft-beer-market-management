package org.assignment.domain.service;

import org.assignment.domain.entity.User;

/**
 * @author Phuongnq
 * Interface UserService
 */
public interface UserService {

	/**
	 * Register new user
	 * @param user - User information
	 */
	void register(User user);

	/**
	 * Check exists user
	 * @param username - The username
	 * @return true -> exists, false -> not exists
	 */
	boolean exists(String username);

}
