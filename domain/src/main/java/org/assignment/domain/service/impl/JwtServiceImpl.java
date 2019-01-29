package org.assignment.domain.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.assignment.domain.entity.Client;
import org.assignment.domain.entity.Token;
import org.assignment.domain.model.TokenInfo;
import org.assignment.domain.repository.ClientRepository;
import org.assignment.domain.repository.TokenRepository;
import org.assignment.domain.service.JwtService;
import org.assignment.domain.util.TokenType;
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

	public static final String DATE_FORMAT = "dd/MM/yyyy hh:mm:ss";

	@Autowired
	TokenRepository tokenRepository;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	PasswordEncoder encoder;

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.JwtService#generateTokenClient(java.lang.String)
	 */
	@Override
	public TokenInfo generateToken(String clientId, TokenType type) {
		String tokenValue = TokenUtils.generateToken(clientId);
		Date expirationDate = TokenUtils.generateExpirationDate();
		Token token = new Token(tokenValue, clientId, expirationDate, type);

		tokenRepository.deleteByOwnerAndType(clientId, type);
		tokenRepository.save(token);

		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		return new TokenInfo(tokenValue, formatter.format(expirationDate));
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.JwtService#checkExistClient(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean checkExistClient(String clientId, String clientSecret) {
		Client client = clientRepository.findByClientIdAndClientSecret(clientId, clientSecret);
		if(client == null) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.JwtService#validateTokenLogin(java.lang.String)
	 */
	@Override
	public boolean validateTokenLogin(String tokenValue) {
		if(!TokenUtils.isValidateTokenFormat(tokenValue)){
			return false;
		}
		Token token = tokenRepository.findOne(tokenValue);
		if(token == null) {
			return false;
		}
		return TokenUtils.validateExpirationDate(token.getExpireTime());
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.JwtService#getUsernameFromToken(java.lang.String)
	 */
	@Override
	public String getUsernameFromToken(String tokenValue) {
		return tokenRepository.getUsernameFromToken(tokenValue, String.valueOf(TokenType.CUSTOMER));
	}

}
