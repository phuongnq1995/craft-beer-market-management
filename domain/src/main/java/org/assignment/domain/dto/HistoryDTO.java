package org.assignment.domain.dto;

/**
 * @author Phuongnq 
 * HistoryDTO
 */
public class HistoryDTO {

	private String beerName;
	private String consumedAt;

	public HistoryDTO(String beerName, String consumedAt) {
		super();
		this.beerName = beerName;
		this.consumedAt = consumedAt;
	}

	/**
	 * @return the beerName
	 */
	public String getBeerName() {
		return beerName;
	}

	/**
	 * @param beerName the beerName to set
	 */
	public void setBeerName(String beerName) {
		this.beerName = beerName;
	}

	/**
	 * @return the consumedAt
	 */
	public String getConsumedAt() {
		return consumedAt;
	}

	/**
	 * @param consumedAt the consumedAt to set
	 */
	public void setConsumedAt(String consumedAt) {
		this.consumedAt = consumedAt;
	}

}
