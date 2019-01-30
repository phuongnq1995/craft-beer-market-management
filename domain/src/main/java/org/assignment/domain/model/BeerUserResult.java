package org.assignment.domain.model;

import java.util.List;

import org.assignment.domain.dto.BeerAvailableDTO;
import org.assignment.domain.dto.HistoryDTO;

/**
 * @author phuongnq
 * BeerUserResult
 */
public class BeerUserResult extends BeerClientResult {

	private List<HistoryDTO> history;

	private List<BeerAvailableDTO> haveNotTried;

	public BeerUserResult(BeerClientResult beerApiResult, List<HistoryDTO> history, List<BeerAvailableDTO> haveNotTried) {
		super(beerApiResult);
		this.history = history;
		this.haveNotTried = haveNotTried;
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

	/**
	 * @return the haveNotTried
	 */
	public List<BeerAvailableDTO> getHaveNotTried() {
		return haveNotTried;
	}

	/**
	 * @param haveNotTried the haveNotTried to set
	 */
	public void setHaveNotTried(List<BeerAvailableDTO> haveNotTried) {
		this.haveNotTried = haveNotTried;
	}

}
