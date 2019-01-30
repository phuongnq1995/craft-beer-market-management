package org.assignment.app.form;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author phuongnq
 * LoginForm
 */
public class LoginForm implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9115374258298607152L;

	@NotEmpty(message="{user.notempty.username}")
	protected String username;

	@NotEmpty(message="{user.notempty.password}")
	protected String password;

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
