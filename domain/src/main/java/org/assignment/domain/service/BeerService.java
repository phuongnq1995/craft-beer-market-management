package org.assignment.domain.service;

import java.util.List;

import org.assignment.domain.dto.BeerDTO;
import org.assignment.domain.entity.Beer;
import org.assignment.domain.model.BeerClientResult;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

/**
 * @author Phuongnq
 * Beer service interface
 */
public interface BeerService {

	/**
	 * Get all beer
	 * @return List beer in database
	 */
	List<BeerDTO> getAll();

	/**
	 * Save a beer
	 * @param beer
	 */
	void save(Beer beer);

	/**
	 * Get a beer
	 * @param beerId
	 * @return Beer
	 * @throws Exception 
	 */
	Beer findByBeerId(Long beerId) throws Exception;

	/**
	 * Delete a beer
	 * @param beerId
	 */
	void delete(Long beerId);

	/**
	 * Get beer by status
	 * @param isArchived
	 * @param authentication
	 * @param page
	 * @param size
	 * @return BeerClientResult
	 */
	BeerClientResult getBeerByStatus(Boolean isArchived, Authentication authentication, Pageable pageable);

}
