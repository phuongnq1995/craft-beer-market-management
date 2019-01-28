package org.assignment.domain.dto;

import java.math.BigDecimal;

public class BeerUser extends BeerAvailableDTO {

	private Passport passport;

	public BeerUser(Long beerId, String manufacturer, String name, String country, String description, BigDecimal price,
			String categoryName) {
		super(beerId, manufacturer, name, country, description, price, categoryName);
	}

	/**
	 * @return the passport
	 */
	public Passport getPassport() {
		return passport;
	}

	/**
	 * @param passport the passport to set
	 */
	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	
}
