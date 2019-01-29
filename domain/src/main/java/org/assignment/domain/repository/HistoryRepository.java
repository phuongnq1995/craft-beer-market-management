package org.assignment.domain.repository;

import java.util.List;

import org.assignment.domain.dto.HistoryDTO;
import org.assignment.domain.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author phuongnq
 * HistoryRepository
 */
public interface HistoryRepository extends JpaRepository<History, String> {

	/**
	 * findHistoryByUser
	 * @param username
	 * @return List<HistoryDTO>
	 */
	@Query(nativeQuery=true)
	List<HistoryDTO> findHistoryByUser(String username);

}
