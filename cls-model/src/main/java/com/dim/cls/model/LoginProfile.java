package com.dim.cls.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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

}
