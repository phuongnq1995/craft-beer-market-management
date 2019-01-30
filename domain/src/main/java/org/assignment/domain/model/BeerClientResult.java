package org.assignment.domain.model;

import org.assignment.domain.dto.BeerAvailableDTO;
import org.springframework.data.domain.Page;

/**
 * @author Phuongnq
 * BeerClientResult
 */
public class BeerClientResult {

	protected Page<BeerAvailableDTO> beers;

	public BeerClientResult(BeerClientResult beerApiResult) {
		this.beers = beerApiResult.getBeers();
	}

	public BeerClientResult() {
		super();
	}

	/**
	 * @return the beers
	 */
	public Page<BeerAvailableDTO> getBeers() {
		return beers;
	}

	/**
	 * @param beers the beers to set
	 */
	public void setBeers(Page<BeerAvailableDTO> beers) {
		this.beers = beers;
	}

	
}
