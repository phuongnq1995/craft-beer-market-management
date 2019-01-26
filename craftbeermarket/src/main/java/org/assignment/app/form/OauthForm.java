package org.assignment.app.form;

import java.io.Serializable;

/**
 * @author Phuongnq
 * TokenForm
 */
public class OauthForm implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6666761231305653550L;

	private String clientId;

	private String clientSecret;

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the clientSecret
	 */
	public String getClientSecret() {
		return clientSecret;
	}

	/**
	 * @param clientSecret the clientSecret to set
	 */
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

}
