package org.assignment.domain.service;

import org.assignment.domain.entity.History;
import org.assignment.domain.entity.User;
import org.assignment.domain.model.TokenInfo;

/**
 * @author phuongnq
 * CustomerService
 */
public interface CustomerService {

	/**
	 * Register
	 * @param user
	 * @return TokenInfo
	 */
	TokenInfo register(User user);

	/**
	 * Add history
	 * @param history
	 * @return History
	 */
	History addHistory(History history);

	/**
	 * Check exist customer
	 * @param username
	 * @param password
	 * @return true if exist else false
	 */
	boolean checkExistCustomer(String username, String password);

}
