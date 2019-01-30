package org.assignment.app.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * @author phuongnq
 * ConsumeForm
 */
public class ConsumeForm implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message="comsume.notnull.beerId")
	private Long beerId;

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

}
