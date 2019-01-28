package org.assignment.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.assignment.domain.util.TokenType;

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

	@Column(name = "owner")
	private String owner;

	@Column(name = "expire_time")
	private Date expireTime;

	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private TokenType type;

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
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
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

	/**
	 * @return the type
	 */
	public TokenType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TokenType type) {
		this.type = type;
	}

	public Token(String value, String owner, Date expireTime, TokenType type) {
		super();
		this.value = value;
		this.owner = owner;
		this.expireTime = expireTime;
		this.type = type;
	}

}
