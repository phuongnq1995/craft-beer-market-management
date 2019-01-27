package org.assignment.domain.repository;

import org.assignment.domain.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Phuongnq
 * TokenRepository
 */
public interface TokenRepository extends JpaRepository<Token, String>{

	/**
	 * getUsernameFromToken
	 * @param tokenValue
	 * @return username
	 */
	@Query(nativeQuery=true)
	String getUsernameFromToken(String tokenValue);

	/**
	 * Delete token by username
	 * @param username
	 */
	void deleteByUsername(String username);

}
