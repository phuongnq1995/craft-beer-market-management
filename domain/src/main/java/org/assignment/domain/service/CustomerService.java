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
	 */
	void addHistory(History history);

}
