package org.assignment.domain.service;

import org.assignment.domain.entity.Oauth;

/**
 * @author Phuongnq
 * OauthService
 */
public interface OauthService {

	/**
	 * checkExistClient
	 * @param oauth
	 * @return Boolean
	 */
	Boolean checkExistClient(Oauth oauth);
}
