package com.dim.cls.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.dim.cls.util.ContactType;

@Embeddable //can embeded in a table of an Entity
public class Address {
	
	@Enumerated(EnumType.ORDINAL)
	private ContactType contactType;
	

	@Column(name="ADDRESS") //the entity object which embeds the Address, will have these column names
	private String address; //Address text
	
	@Column
	private String homeNumber;
	
	@Column
	private String streetName;
	
	@Column
	private String town;
	
	@Column
	private String city;
	
	@Column
	private String country;

	public ContactType getContactType() {
		return contactType;
	}
	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}
	public String getHomeNumber() {
		return homeNumber;
	}
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Address [contactType=" + contactType + ", homeNumber=" + homeNumber + ", streetName=" + streetName
				+ ", town=" + town + ", city=" + city + ", country=" + country + "]";
	}
	
	
	
}
