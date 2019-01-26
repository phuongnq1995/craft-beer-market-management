package org.assignment.domain.service.impl;

import org.assignment.domain.entity.Oauth;
import org.assignment.domain.repository.OauthRepository;
import org.assignment.domain.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Phuongnq
 * OauthServiceImpl
 */
@Service
@Transactional
public class OauthServiceImpl implements OauthService {

	@Autowired
	OauthRepository oauthRepository;

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.OauthService#checkExistClient(org.assignment.domain.entity.Oauth)
	 */
	@Override
	public Boolean checkExistClient(Oauth oauth) {
		return oauthRepository.existClient(oauth.getClientId(), oauth.getClientSecret()) == 1;
	}

}
