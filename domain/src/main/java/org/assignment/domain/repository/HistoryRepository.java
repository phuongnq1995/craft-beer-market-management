package org.assignment.domain.repository;

import org.assignment.domain.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author phuongnq
 * HistoryRepository
 */
public interface HistoryRepository extends JpaRepository<History, String> {

}
