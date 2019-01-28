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

	@Override
	public TokenInfo register(User user) {
		userService.registerCustomer(user);
		return jwtService.generateToken(user.getUsername(), TokenType.CUSTOMER);
	}

	@Override
	public void addHistory(History history) {
		historyRepository.save(history);
	}

}
