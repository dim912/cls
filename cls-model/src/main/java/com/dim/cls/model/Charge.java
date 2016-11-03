package com.dim.cls.model;


import java.sql.Date;

import javax.persistence.Entity;

import com.dim.cls.model.abstracts.AbstractCharge;
import com.dim.cls.util.ChargeTypes;

//@Entity
public class Charge extends AbstractCharge  {


	private Subject subject;
	private Date startDate;
	private Date endDate;
	private ChargeTypes chargeType; //rental or admission
	
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
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
	public ChargeTypes getChargeType() {
		return chargeType;
	}
	public void setChargeType(ChargeTypes chargeType) {
		this.chargeType = chargeType;
	}
	
}
