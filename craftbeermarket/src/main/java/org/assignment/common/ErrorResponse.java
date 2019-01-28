package org.assignment.common;

import org.springframework.http.HttpStatus;

/**
 * @author phuongnq
 * ErrorResponse
 */
public class ErrorResponse {

	private String message;

	private int status;

	public ErrorResponse(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status.value();
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	
}
