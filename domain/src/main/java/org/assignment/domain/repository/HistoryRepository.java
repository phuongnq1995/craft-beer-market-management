package org.assignment.domain.repository;

import java.util.List;

import org.assignment.domain.dto.HistoryDTO;
import org.assignment.domain.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author phuongnq
 * HistoryRepository
 */
public interface HistoryRepository extends JpaRepository<History, String> {

	/**
	 * findHistoryByUser
	 * {@code META-INF/jpa/history-orm.xml} file.
	 * @param username
	 * @return List<HistoryDTO> history drank beers by user
	 */
	List<HistoryDTO> findHistoryByUser(@Param("username")String username);

}
