package org.assignment.app.form;

import java.io.Serializable;

/**
 * @author phuongnq
 * BaseForm
 */
public class BaseForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Integer version;

	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

}
