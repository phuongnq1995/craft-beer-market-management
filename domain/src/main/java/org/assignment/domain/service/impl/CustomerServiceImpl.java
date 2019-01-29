package org.assignment.domain.service.impl;

import org.assignment.domain.entity.History;
import org.assignment.domain.entity.User;
import org.assignment.domain.model.TokenInfo;
import org.assignment.domain.repository.HistoryRepository;
import org.assignment.domain.service.CustomerService;
import org.assignment.domain.service.JwtService;
import org.assignment.domain.service.UserService;
import org.assignment.domain.util.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author phuongnq
 * CustomerServiceImpl
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	UserService userService;

	@Autowired
	JwtService jwtService;

	@Autowired
	HistoryRepository historyRepository;

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.CustomerService#register(org.assignment.domain.entity.User)
	 */
	@Override
	public TokenInfo register(User user) {
		userService.registerCustomer(user);
		return jwtService.generateToken(user.getUsername(), TokenType.CUSTOMER);
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.CustomerService#addHistory(org.assignment.domain.entity.History)
	 */
	@Override
	public History addHistory(History history) {
		return historyRepository.save(history);
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.CustomerService#checkExistCustomer(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean checkExistCustomer(String username, String password) {
		return userService.checkExistUser(username, password);
	}

}
