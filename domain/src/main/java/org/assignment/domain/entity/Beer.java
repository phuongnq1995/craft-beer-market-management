package org.assignment.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Phuongnq
 * Beer entity
 * Table name "beer"
 */
@Entity
@Table(name="beer")
public class Beer implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5823708872964400506L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="beer_id")
	private Long beerId;

	@Column(name="manufacturer")
	private String manufacturer;

	@Column(name="name")
	private String name;

	@Column(name="country")
	private String country;

	@Column(name="price")
	private BigDecimal price;

	@Column(name="description")
	private String description;

	@Column(name="category_id")
	private Long categoryId;

	@Column(name="is_archive")
	private Boolean isArchive;

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
	 * @return the categoryId
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the isArchive
	 */
	public Boolean getIsArchive() {
		return isArchive;
	}

	/**
	 * @param isArchive the isArchive to set
	 */
	public void setIsArchive(Boolean isArchive) {
		this.isArchive = isArchive;
	}

}
