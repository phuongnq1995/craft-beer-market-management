package org.assignment.domain.repository;

import org.assignment.domain.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Phuongnq
 * Beer repository
 * Using interact data table "beer"
 */
public interface BeerRepository extends JpaRepository<Beer, Long> {

}
