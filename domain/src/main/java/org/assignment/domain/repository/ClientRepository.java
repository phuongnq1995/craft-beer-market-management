package org.assignment.domain.repository;

import org.assignment.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Phuongnq
 * ClientRepository
 */
public interface ClientRepository extends JpaRepository<Client, String> {

	/**
	 * Find by clientId and clientSecret
	 * @param clientId
	 * @param clientSecret
	 * @return Client
	 */
	Client findByClientIdAndClientSecret(String clientId, String clientSecret);

}
