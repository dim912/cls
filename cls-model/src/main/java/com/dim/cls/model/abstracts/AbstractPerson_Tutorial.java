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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
import com.dim.cls.model.Institute;
//import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import com.dim.cls.util.GenderType;

/**
 * @author Hangil1D
 *
 */
/*
 * table per class hierarchy -> one table in db for all classes inheriting the
 * class. descriminator column in table used for differentiation object type
 * table per subclass -> each concrete class is mapped to a table, including
 * inherited fields. joined inheritance -> root of the class hierarchy by a
 * single table and each subclass has separate tables. inherited colums are in
 * it root table. subclass table has the primary key of the supperclass table as
 * a forign key
 */

@Entity // Entity bean. Hibernate to coniser this class as a RDBMS entity. Class
		// should have a no argument constructor visible
		// atleast protected
// each entity should have a primary key(may be one or more colums)
// @Entity(name="U_USER")

@Table(name = "U_USER") // set Table name.
/*
 * This is differnet from the name at @Entity(name=""), since => the name
 * property of the @Entity chanegs the name of the Entity itself. But @Table,
 * name chanegs only for the table. => name of the Entity matters in hql.
 */

// @Cacheable
// @Cache(usage=CacheConcurrencyStrategy.READ_ONLY)

@Inheritance(strategy = InheritanceType.JOINED)

// @DiscriminatorColumn( descriminator is not needed since joined table
// inheritnce type is used
// name="discriminator",
// discriminatorType=DiscriminatorType.STRING
// )
public abstract class AbstractPerson_Tutorial {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	// @GeneratedValue(strategy=GenerationType.SEQUENCE)
	// @GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "ID_INTERNAL")
	private Long IdInternal;

	@Column(name = "FIRST_NAME") // map the db column to which the attribute matches
	private String firstName;

	@Column(name = "SECOND_NAME")
	private String secondName;

	@Column(name = "SURNAME")
	private String surName;

	@ElementCollection
	@CollectionTable(name = "T_IDENTITIES", joinColumns = @JoinColumn(name = "ID_INTERNAL"))
	private List<Identity> identities;

	@Column(name = "DOB", columnDefinition = "DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE) // save only the date
	private Date dob;

	@Column(name = "GENDER")
	@Enumerated(EnumType.STRING)
	@NotFound(action = NotFoundAction.IGNORE)
	private GenderType gender;

	// @Embedded
	// private Address homeAddress; //no need to create a separte table for
	// homeAddress. but include in the same table since it is a value object.

	@ElementCollection
	@CollectionTable(name = "T_ADDRESS", joinColumns = @JoinColumn(name = "ID_INTERNAL"))
	private List<Address> address;

	/*
	 * @ManyToMany(fetch = FetchType.LAZY)
	 * 
	 * @JoinTable(name = "_R", joinColumns = {
	 * 
	 * @JoinColumn(name = "ID_INTERNAL", nullable = false) }, inverseJoinColumns
	 * = { @JoinColumn(name = "ID_INTERNAL_SUB", nullable = false) }) private
	 * AbstractPerson[] sibilians;
	 */

	@ElementCollection
	private List<AcadamicQualification> acadamicQualifications;

	@ElementCollection
	@CollectionTable(name = "T_CONTACT", joinColumns = @JoinColumn(name = "ID_INTERNAL"))
	private List<ContactNumber> contactnumbers;

	@ManyToOne // many to one in database layer. many person can be mapped to
				// same institute
	private Institute school;

	/*
	 * // Entity to Entity relationships
	 * 
	 * @OneToOne // Abstract person column will have a colom as fater where
	 * fatehs // primary key can be stored. (Not object level oneToOne, but //
	 * relational level)
	 * 
	 * @JoinColumn(name = "father_id") private AbstractPerson father;
	 */

	// Entity to Entity relationship
	@OneToMany(cascade = CascadeType.PERSIST) // table level oneto Many
	@JoinColumn // by default hibernate will create a table as
				// AbstractPerson_subordinates table which contain the mapping
				// info.
	@JoinTable(name = "U_SUBORDINATES", joinColumns = {
			@JoinColumn(name = "ID_INTERNAL", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ID_INTERNAL_SUB", nullable = false) })
	private Collection<AbstractPerson_Tutorial> subordinates;

	// Entity to Entity relationships
	@ManyToMany(fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@JoinTable(name = "U_EMERGENCY_CONTACT", joinColumns = {
			@JoinColumn(name = "ID_INTERNAL", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ID_INTERNAL_EME", nullable = false) })
	private List<AbstractPerson_Tutorial> emergencyContactPersons;

	Long getIdInternal() {
		return IdInternal;
	}

	public void setIdInternal(Long idInternal) {
		IdInternal = idInternal;
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
		System.out.println("Yeswwddsfs");
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

	public List<AbstractPerson_Tutorial> getEmergencyContactPersons() {
		return emergencyContactPersons;
	}

	public void setEmergencyContactPersons(List<AbstractPerson_Tutorial> emergencyContactPersons) {
		this.emergencyContactPersons = emergencyContactPersons;
	}

	public boolean isNew() { // return true if the user is new
		return (this.IdInternal == null);
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

}
