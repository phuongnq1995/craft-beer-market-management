package org.assignment.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author phuongnq 
 * ApiError
 */
public class ApiError implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String code;

	private final String message;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private final String target;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private final List<ApiError> details = new ArrayList<>();

	public ApiError(String code, String message) {
		this(code, message, null);
	}

	public ApiError(String code, String message, String target) {
		this.code = code;
		this.message = message;
		this.target = target;
	}

	/**
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return target
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * @return details
	 */
	public List<ApiError> getDetails() {
		return details;
	}

	public void addDetail(ApiError detail) {
		details.add(detail);
	}

}
