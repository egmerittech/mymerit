package com.github.egmerittech.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * A base abstract entity that includes a PK field.
 *
 * @author Greg Baker
 */
@MappedSuperclass
@SuppressWarnings("serial")
public abstract class AbstractEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;


	protected Calendar dateCreated;


	protected Calendar dateUpdated;


	@PrePersist
	public void prePersist() {
		dateCreated = Calendar.getInstance();
	}


	@PreUpdate
	public void preUpdate() {
		dateUpdated = Calendar.getInstance();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Calendar getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Calendar dateCreated) {
		this.dateCreated = dateCreated;
	}


	public Calendar getDateUpdated() {
		return dateUpdated;
	}


	public void setDateUpdated(Calendar dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

}
