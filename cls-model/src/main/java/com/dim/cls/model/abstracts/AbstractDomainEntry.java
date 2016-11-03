package com.dim.cls.model.abstracts;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


// No Entity will be associated directly with AbstractDomainEntry, and no object of it will be created.
//But only  more specific objects will be associated with each other
//So AbstractDomainEntry is not an Entity, but a @MappedSuperclass.
// clild class objects like Person, Course, Registration etc.
//
// @MappedSuperclass also has a persistance state and mapping info. But are not entites.
//@MappedSuperclass => these are not mapped as entiteis by the JPA provider.
//@MappedSuperclass => can not be used in JPA queries.
//@MappedSuperclass => can not be target in entity repationships
//@MappedSuperclass => do not have any table => allways goes in table per class fasion.
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class AbstractDomainEntry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_INTERNAL")
	private Long idInternal;

	@Column(name="STATUS")
	private String status;
	
	@Column(name = "ID_CREATED_BY")
	private Long idCreatedBy;
	
	@Column(name = "DT_CREATED", columnDefinition = "DATE")
	@DateTimeFormat(pattern = "yyyyMMddHH24MISS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtCreated;
	
	@Column(name = "ID_LAST_UPDATED_BY")
	private Long idLastUpdatedBy;
	
	@Column(name = "DT_LAST_UPDATED", columnDefinition = "DATE")
	@DateTimeFormat(pattern = "yyyyMMddHH24MISS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtLastUpdated;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getIdCreatedBy() {
		return idCreatedBy;
	}

	public void setIdCreatedBy(Long idCreatedBy) {
		this.idCreatedBy = idCreatedBy;
	}

	public Date getDtCreated() {
		return dtCreated;
	}

	/*
	public void setDtCreated(Date dtCreated) {
		this.dtCreated = dtCreated;
	}
	*/

	public Long getIdLastUpdatedBy() {
		return idLastUpdatedBy;
	}

	public void setIdLastUpdatedBy(Long idLastUpdatedBy) {
		this.idLastUpdatedBy = idLastUpdatedBy;
	}

	public Date getDtLastUpdated() {
		return dtLastUpdated;
	}

	public boolean isNew() { // return true if the user is new
		return (this.idInternal == null);
	}
	
	/*
	public void setDtLastUpdated(Date dtLastUpdated) {
		this.dtLastUpdated = dtLastUpdated;
	}
	*/
	
	@PrePersist
    protected void onCreate() {
		System.out.println("asdfasd");
		dtCreated = new Date();
		System.out.println("bbbbbbbb");
    	dtLastUpdated = new Date();
    }
		
}
