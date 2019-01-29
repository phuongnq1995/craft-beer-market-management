package org.assignment.domain.entity;

import java.io.Serializable;
import java.util.Date;  

import javax.persistence.Column;  
import javax.persistence.MappedSuperclass;  
import javax.persistence.PrePersist;  
import javax.persistence.PreUpdate;  
import javax.persistence.Temporal;  
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;  

/**
 * @author phuongnq 
 * BaseEntityAudit
 */
@MappedSuperclass
public abstract class BaseEntityAudit implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private static final String AUTHOR_WEB_API = "WEB-API";

	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdAt;

	@Size(max = 20)
	@Column(name = "created_by", length = 20)
	protected String createdBy;

	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date updatedAt;

	@Size(max = 20)
	@Column(name = "updated_by", length = 20)
	protected String updatedBy;

	@Version
	@Column(name="version")
	protected Integer version;

	/**
	 * Sets createdAt before insert
	 */
	@PrePersist
	public void setCreationDate() {
		this.createdBy = getUserLogged();
		this.createdAt = new Date();
	}

	/**
	 * Sets updatedAt before update
	 */
	@PreUpdate
	public void setChangeDate() {
		this.updatedBy = getUserLogged();
		this.updatedAt = new Date();
	}

	/**
	 * @return current user logged
	 */
	private String getUserLogged() {
		// Get user logged
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		// if non-user logged
		if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return AUTHOR_WEB_API;
		}
		return authentication.getName();
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

}
