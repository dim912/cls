package com.dim.cls.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@NamedQueries({
	@NamedQuery(
	name = "findByUserName",
	query = "from LoginProfile lp where lp.uerName = :userName AND lp.password = :password"
	)
})
@Entity
@XmlRootElement
public class LoginProfile {

	@Column
	@Id
	private String uerName;
	@Column
	@XmlTransient
	private String password;

	@Column(name = "DOB", columnDefinition = "DATE")
	@Temporal(TemporalType.TIMESTAMP) // save only the date
	private Date lastLoginTime;

	@Transient
	private boolean isLoggedIn = false;
	
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private StaffMember staffMember;
	
	public String getUerName() {
		System.out.println("adsff");
		return uerName;
	}

	public void setUerName(String uerName) {
		this.uerName = uerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public StaffMember getStaffMember() {
		return staffMember;
	}

	public void setStaffMember(StaffMember staffMember) {
		this.staffMember = staffMember;
	}
	
	

}
