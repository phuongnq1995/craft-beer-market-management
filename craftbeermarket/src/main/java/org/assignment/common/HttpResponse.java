package org.assignment.common;

import org.springframework.http.HttpStatus;

/**
 * @author phuongnq
 * HttpResponse
 */
public class HttpResponse {

	private String message;

	private int status;

	public HttpResponse(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status.value();
	}

	public HttpResponse() {
		
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
