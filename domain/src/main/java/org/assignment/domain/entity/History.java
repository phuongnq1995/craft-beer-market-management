package org.assignment.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author phuongnq
 * History
 */
@Entity
@Table(name="history")
public class History extends BaseEntityAudit {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8766612809208803659L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="history_id")
	private Long historyId;

	@Column(name="username")
	private String username;

	@Column(name="beer_id")
	private Long beerId;

	/**
	 * @return the historyId
	 */
	public Long getHistoryId() {
		return historyId;
	}

	/**
	 * @param historyId the historyId to set
	 */
	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	 * @return the beerId
	 */
	public Long getBeerId() {
		return beerId;
	}

	/**
	 * @param beerId the beerId to set
	 */
	public void setBeerId(Long beerId) {
		this.beerId = beerId;
	}

	public History() {
		super();
	}

	public History(String username, Long beerId) {
		super();
		this.username = username;
		this.beerId = beerId;
	}

}
