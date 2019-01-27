package org.assignment.domain.service.impl;

import org.assignment.domain.entity.Token;
import org.assignment.domain.entity.User;
import org.assignment.domain.repository.TokenRepository;
import org.assignment.domain.repository.UserRepository;
import org.assignment.domain.service.JwtService;
import org.assignment.domain.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Phuongnq
 * JwtServiceImpl
 */
@Service
@Transactional
public class JwtServiceImpl implements JwtService {

	@Autowired
	TokenRepository tokenRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.JwtService#generateTokenLogin(java.lang.String)
	 */
	@Override
	public String generateTokenLogin(String username) {

		String tokenValue = TokenUtils.generateToken(username);

		Token token = new Token(tokenValue, username, TokenUtils.generateExpirationDate());

		tokenRepository.deleteByUsername(username);
		tokenRepository.save(token);

		return tokenValue;
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.JwtService#checkExistClient(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean checkExistUser(String username, String passwordRaw) {
		User user = userRepository.findOne(username);
		if(user == null || !encoder.matches(passwordRaw, user.getPassword())) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.JwtService#validateTokenLogin(java.lang.String)
	 */
	@Override
	public boolean validateTokenLogin(String tokenValue) {
		if(tokenValue == null || tokenValue.isEmpty()) {
			return false;
		}
		Token token = tokenRepository.findOne(tokenValue);
		return TokenUtils.validateTokenLogin(token);
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.JwtService#getUsernameFromToken(java.lang.String)
	 */
	@Override
	public String getUsernameFromToken(String tokenValue) {
		return tokenRepository.getUsernameFromToken(tokenValue);
	}
}
