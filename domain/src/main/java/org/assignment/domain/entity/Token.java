package org.assignment.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Phuongnq
 * Token
 */
@Entity
@Table(name = "token")
public class Token extends BaseEntityAudit {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1653591646622965488L;

	@Id
	private String value;

	@Column(name = "username")
	private String username;

	@Column(name = "expire_time")
	private Date expireTime;

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

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
	 * @return the expireTime
	 */
	public Date getExpireTime() {
		return expireTime;
	}

	/**
	 * @param expireTime the expireTime to set
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public Token() {
		super();
	}

	public Token(String value, String username, Date expireTime) {
		super();
		this.value = value;
		this.username = username;
		this.expireTime = expireTime;
	}

}
