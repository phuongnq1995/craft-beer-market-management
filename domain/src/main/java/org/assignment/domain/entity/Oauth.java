package org.assignment.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Phuongnq
 * Oauth
 */
@Entity
@Table(name="oauth")
public class Oauth extends BaseEntityAudit {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2697089826261898086L;

	@Id
	@Column(name="client_id")
	private String clientId;

	@Column(name="client_secret")
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
