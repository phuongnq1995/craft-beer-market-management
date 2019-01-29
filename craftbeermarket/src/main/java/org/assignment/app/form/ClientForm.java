package org.assignment.app.form;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Phuongnq
 * ClientForm
 */
public class ClientForm implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6666761231305653550L;

	@NotEmpty(message="{client.notempty.clientId}")
	private String clientId;

	@NotEmpty(message="{client.notempty.clientSecret}")
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
