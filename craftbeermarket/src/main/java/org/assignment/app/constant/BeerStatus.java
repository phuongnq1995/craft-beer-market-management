package org.assignment.app.constant;

/**
 * @author Phuongnq 
 * BeerStatus
 */
public enum BeerStatus {

	ARCHIVED("Archived", true),
	AVAILABLE("Available", false);

	private String name;
	private boolean value;
	

	BeerStatus(String name, boolean value) {
		this.value = value;
		this.name = name;
	}

	public boolean getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
}
