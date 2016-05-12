package com.dim.cls.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.dim.cls.util.ContactType;

@Embeddable
public class ContactNumber {

	@Column
	private String value;
	
	@Column
	private ContactType contactType;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public ContactType getContactType() {
		return contactType;
	}
	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}
	@Override
	public String toString() {
		return "ContactNumber [value=" + value + ", contactType=" + contactType + "]";
	}
	
	
}
