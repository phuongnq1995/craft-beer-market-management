package org.assignment.app.form;

import java.io.Serializable;

/**
 * @author Phuongnq
 * TokenForm
 */
public class ClientForm implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6666761231305653550L;

	private String username;

	private String password;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
