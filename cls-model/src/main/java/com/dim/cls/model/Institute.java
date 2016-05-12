package com.dim.cls.model;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.dim.cls.util.InstituteType;

@Entity
public class Institute {

	@Id
    @GeneratedValue
	private Long IdInternal;
	
	@Column
	private String instituteName;
	
	@Enumerated(EnumType.ORDINAL)
	private InstituteType instituteType;
	
	@Column
	private Address address;
	
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public InstituteType getInstituteType() {
		return instituteType;
	}
	public void setInstituteType(InstituteType instituteType) {
		this.instituteType = instituteType;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
