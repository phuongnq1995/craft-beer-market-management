package org.assignment.app.form;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Phuongnq
 * AuthForm using interact between server and client
 */
public class AuthForm implements Serializable {

	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9115374258298607152L;

	@NotEmpty(message="{user.notempty.username}")
	private String username;

	@NotEmpty(message="{user.notempty.fullname}")
	private String fullname;

	@NotEmpty(message="{user.notempty.password}")
	private String password;

	@NotEmpty(message="{user.notempty.passwordConfirm}")
	private String passwordConfirm;

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
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	/**
	 * @return the passwordConfirm
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	/**
	 * @param passwordConfirm the passwordConfirm to set
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

}
