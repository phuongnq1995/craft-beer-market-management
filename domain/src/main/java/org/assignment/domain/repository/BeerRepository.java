package org.assignment.domain.repository;

import java.util.List;

import org.assignment.domain.entity.Beer;
import org.assignment.domain.model.BeerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Phuongnq
 * Beer repository
 * Using interact data table "beer"
 */
public interface BeerRepository extends JpaRepository<Beer, Long> {

	/**
	 * getAllBeer store query in {@code META-INF/jpa-named-queries.properties} file.
	 * @return all beer information
	 */
	@Query(nativeQuery=true)
	List<BeerModel> getAllBeer();

}