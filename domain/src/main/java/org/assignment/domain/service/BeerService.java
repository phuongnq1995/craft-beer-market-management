package org.assignment.domain.service;

import java.util.List;

import org.assignment.domain.entity.Beer;

/**
 * @author Phuongnq
 * Beer service interface
 */
public interface BeerService {

	/**
	 * Get all beer
	 * @return List beer in database
	 */
	List<Beer> getAll();

	/**
	 * Save a beer
	 * @param beer
	 */
	void save(Beer beer);

}
