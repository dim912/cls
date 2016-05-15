/**
 * 
 */
package com.dim.cls.model.abstracts;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.dim.cls.model.AcadamicQualification;
import com.dim.cls.model.Address;
import com.dim.cls.model.ContactNumber;
import com.dim.cls.model.Identity;
import com.dim.cls.util.GenderType;

@Entity
@Table(name = "U_USER") // set Table name.
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractPerson {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_INTERNAL")
	private Long idInternal;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "SECOND_NAME")
	private String secondName;

	@Column(name = "SURNAME")
	private String surName;

	@ElementCollection
	@CollectionTable(name = "U_IDENTITIES", joinColumns = @JoinColumn(name = "ID_INTERNAL"))
	private List<Identity> identities;

	@Column(name = "DOB", columnDefinition = "DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name = "GENDER")
	@Enumerated(EnumType.STRING)
	@NotFound(action = NotFoundAction.IGNORE)
	private GenderType gender;

	@ElementCollection
	@CollectionTable(name = "T_ADDRESS", joinColumns = @JoinColumn(name = "ID_INTERNAL"))
	private List<Address> address;

	
	/*
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "U_RELATIONS", joinColumns = { 
	@JoinColumn(name = "ID_INTERNAL", nullable = false) }, inverseJoinColumns
	= { @JoinColumn(name = "ID_INTERNAL_R", nullable = false) }) 
	private AbstractPerson[] relations;
	*/
	
	@ElementCollection
	private List<AcadamicQualification> acadamicQualifications;

	@ElementCollection
	@CollectionTable(name = "T_CONTACT", joinColumns = @JoinColumn(name = "ID_INTERNAL"))
	private List<ContactNumber> contactnumbers;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn
	@JoinTable(name = "U_SUBORDINATES", joinColumns = {
			@JoinColumn(name = "ID_INTERNAL", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ID_INTERNAL_SUB", nullable = false) })
	private Collection<AbstractPerson> subordinates;

	@ManyToMany(fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@JoinTable(name = "U_EMERGENCY_CONTACT", joinColumns = {
			@JoinColumn(name = "ID_INTERNAL", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ID_INTERNAL_EME", nullable = false) })
	private List<AbstractPerson> emergencyContactPersons;

	Long getIdInternal() {
		return idInternal;
	}

	public void setIdInternal(Long idInternal) {
		this.idInternal = idInternal;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public List<Identity> getIdentities() {
		return identities;
	}

	public void setIdentities(List<Identity> identities) {
		this.identities = identities;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<AcadamicQualification> getAcadamicQualifications() {
		return acadamicQualifications;
	}

	public void setAcadamicQualifications(List<AcadamicQualification> acadamicQualifications) {
		this.acadamicQualifications = acadamicQualifications;
	}

	public List<ContactNumber> getContactnumbers() {
		return contactnumbers;
	}

	public void setContactnumbers(List<ContactNumber> contactnumbers) {
		this.contactnumbers = contactnumbers;
	}

	public List<AbstractPerson> getEmergencyContactPersons() {
		return emergencyContactPersons;
	}

	public void setEmergencyContactPersons(List<AbstractPerson> emergencyContactPersons) {
		this.emergencyContactPersons = emergencyContactPersons;
	}

	public boolean isNew() { // return true if the user is new
		return (this.idInternal == null);
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

}
