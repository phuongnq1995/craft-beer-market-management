package org.assignment.domain.service;

import java.util.List;

import org.assignment.domain.entity.Beer;
import org.assignment.domain.model.BeerModel;

/**
 * @author Phuongnq
 * Beer service interface
 */
public interface BeerService {

	/**
	 * Get all beer
	 * @return List beer in database
	 */
	List<BeerModel> getAll();

	/**
	 * Save a beer
	 * @param beer
	 */
	void save(Beer beer);

	/**
	 * Get a beer
	 * @param beerId
	 * @return Beer
	 */
	Beer findByBeerId(Long beerId);

	/**
	 * Delete a beer
	 * @param beerId
	 */
	void delete(Long beerId);

}
