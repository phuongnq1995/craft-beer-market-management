package org.assignment.domain.model;

/**
 * @author phuongnq TokenInfo
 */
public class TokenInfo {

	private String token;

	private String expireTime;

	public TokenInfo(String token, String expireTime) {
		super();
		this.token = token;
		this.expireTime = expireTime;
	}

	public TokenInfo() {
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the expireTime
	 */
	public String getExpireTime() {
		return expireTime;
	}

	/**
	 * @param expireTime the expireTime to set
	 */
	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

}
