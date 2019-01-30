package org.assignment.domain.repository;

import java.util.List;
import org.assignment.domain.dto.BeerAvailableDTO;
import org.assignment.domain.dto.BeerDTO;
import org.assignment.domain.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Phuongnq
 * Beer repository
 * Using interact data table "beer"
 */
public interface BeerRepository extends JpaRepository<Beer, Long> {

	/**
	 * Get all beers
	 * {@code META-INF/jpa/beer-orm.xml} file.
	 * @return all beer information
	 */
	List<BeerDTO> getAllBeer();

	/**
	 * Get list of beers by status
	 * {@code META-INF/jpa/beer-orm.xml} file.
	 * @param isArchived
	 * @param offset
	 * @param limit
	 * @return List<BeerAvailableDTO> available
	 */
	List<BeerAvailableDTO> getBeerByStatus(
		@Param("isArchived") Boolean isArchived, 
		@Param("size") int size, 
		@Param("from") int from);

	/**
	 * Get list of beers have not tried
	 * {@code META-INF/jpa/beer-orm.xml} file.
	 * @param isArchived
	 * @param username
	 * @return List<BeerAvailableDTO> have not tried
	 */
	List<BeerAvailableDTO> getBeerHaveNotTried(
			@Param("isArchived") Boolean isArchived, 
			@Param("username") String username);

	/**
	 * Count beers by status
	 * {@code META-INF/jpa/beer-orm.xml} file.
	 * @param isArchived
	 * @return size
	 */
	long countBeerByStatus(@Param("isArchived") Boolean isArchived);

}
