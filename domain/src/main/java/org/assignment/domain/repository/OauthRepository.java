package org.assignment.domain.repository;

import org.assignment.domain.entity.Oauth;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Phuongnq
 * OauthRepository
 */
public interface OauthRepository extends JpaRepository<Oauth, String>{

	/**
	 * existClient
	 * @param oauth
	 * @return Integer
	 */
	Integer existClient(String clientId, String clientSecret);

}
