package org.assignment.domain.model;

import java.math.BigDecimal;

/**
 * @author phuongnq BeerModel
 */
public class BeerModel {

	private Long beerId;
	private String manufacturer;
	private String name;
	private String country;
	private String description;
	private BigDecimal price;
	private Long categoryName;
	private Boolean isArchived;

	/**
	 * @return the beerId
	 */
	public Long getBeerId() {
		return beerId;
	}

	/**
	 * @param beerId the beerId to set
	 */
	public void setBeerId(Long beerId) {
		this.beerId = beerId;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the categoryName
	 */
	public Long getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(Long categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the isArchived
	 */
	public Boolean getIsArchived() {
		return isArchived;
	}

	/**
	 * @param isArchived the isArchived to set
	 */
	public void setIsArchived(Boolean isArchived) {
		this.isArchived = isArchived;
	}

	public BeerModel(Long beerId, String manufacturer, String name, String country, String description,
			BigDecimal price, Long categoryName, Boolean isArchived) {
		super();
		this.beerId = beerId;
		this.manufacturer = manufacturer;
		this.name = name;
		this.country = country;
		this.description = description;
		this.price = price;
		this.categoryName = categoryName;
		this.isArchived = isArchived;
	}

	public BeerModel() {
		super();
	}
}
