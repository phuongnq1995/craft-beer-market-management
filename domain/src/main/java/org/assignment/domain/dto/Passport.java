package org.assignment.domain.dto;

/**
 * @author Phuongnq Passport
 */
public class Passport {

	private String beerName;
	private String consumedAt;

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
