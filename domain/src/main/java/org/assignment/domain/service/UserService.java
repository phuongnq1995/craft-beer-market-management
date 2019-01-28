package org.assignment.domain.service;

import org.assignment.domain.entity.User;

/**
 * @author Phuongnq
 * Interface UserService
 */
public interface UserService {

	/**
	 * Register new user admin
	 * @param user - User information
	 */
	void registerAdmin(User user);

	/**
	 * Check exists user
	 * @param username - The username
	 * @return true -> exists, false -> not exists
	 */
	boolean exists(String username);

	/**
	 * Register customer
	 * @param user
	 */
	void registerCustomer(User user);
}
