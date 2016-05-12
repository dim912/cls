package com.dim.cls.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.dim.cls.util.Grade;

@Embeddable
public class AcadamicQualification {
	
	@ManyToOne
	private Institute institute;
	
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	
	//@ElementCollection
	//private List<String> specialization;
	
	@Column
	private Grade higherstGrade;
	public Institute getInstitute() {
		return institute;
	}
	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Grade getHigherstGrade() {
		return higherstGrade;
	}
	public void setHigherstGrade(Grade higherstGrade) {
		this.higherstGrade = higherstGrade;
	}
		
}
