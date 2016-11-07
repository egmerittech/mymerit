package com.github.egmerittech.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * A base abstract entity that includes a PK field.
 *
 * @author Greg Baker
 */
@MappedSuperclass
public abstract class AbstractEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

}
