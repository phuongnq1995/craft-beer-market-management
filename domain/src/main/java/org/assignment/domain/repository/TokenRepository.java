package org.assignment.domain.repository;

import org.assignment.domain.entity.Token;
import org.assignment.domain.util.TokenType;
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
	String getUsernameFromToken(String tokenValue, String type);

	/**
	 * Delete By Username And Type
	 * @param username - The username
	 * @param type - TokenType
	 */
	void deleteByOwnerAndType(String owner, TokenType type);

}
