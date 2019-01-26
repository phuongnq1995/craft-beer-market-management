package org.assignment.common;

/**
 * @author phuongnq
 * MessageType
 */
public enum MessageType {

	SUCCESS("success"),
	INFO("info"), 
	WARNING("warning"), 
	ERROR("danger");

	private String value;

	MessageType(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
