package com.dim.cls.model;

import java.sql.Date;

import com.dim.cls.model.abstracts.AbstractPerson;

public abstract class Transaction {

	private Date createdDate;
	private AbstractPerson person; //who is paying this
	private int amount;
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public AbstractPerson getPerson() {
		return person;
	}
	public void setPerson(AbstractPerson person) {
		this.person = person;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
