package org.assignment.domain.model;

import java.util.List;
import org.assignment.domain.dto.BeerAvailableDTO;
import org.assignment.domain.dto.HistoryDTO;

/**
 * @author phuongnq
 * UserPassport
 */
public class UserPassport {

	private List<BeerAvailableDTO> beers;
	private List<HistoryDTO> history;

	public UserPassport(List<BeerAvailableDTO> beers, List<HistoryDTO> history) {
		super();
		this.beers = beers;
		this.history = history;
	}

	/**
	 * @return the beers
	 */
	public List<BeerAvailableDTO> getBeers() {
		return beers;
	}

	/**
	 * @param beers the beers to set
	 */
	public void setBeers(List<BeerAvailableDTO> beers) {
		this.beers = beers;
	}

	/**
	 * @return the history
	 */
	public List<HistoryDTO> getHistory() {
		return history;
	}

	/**
	 * @param history the history to set
	 */
	public void setHistory(List<HistoryDTO> history) {
		this.history = history;
	}

}
