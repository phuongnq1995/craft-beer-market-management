package org.assignment.domain.repository;

import org.assignment.domain.entity.Token;
import org.assignment.domain.util.TokenType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Phuongnq
 * TokenRepository
 */
public interface TokenRepository extends JpaRepository<Token, String>{

	/**
	 * getUsernameFromToken
	 * {@code META-INF/jpa/token-orm.xml} file.
	 * @param tokenValue
	 * @return username
	 */
	String getUsernameFromToken(@Param("tokenValue") String tokenValue, 
			@Param("type") String type);

	/**
	 * Delete By Username And Type
	 * @param username - The username
	 * @param type - TokenType
	 */
	void deleteByOwnerAndType(String owner, TokenType type);

}
