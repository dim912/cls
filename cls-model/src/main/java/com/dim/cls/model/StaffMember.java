package com.dim.cls.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.dim.cls.model.abstracts.AbstractPerson;
import com.dim.cls.util.GenderType;

@Entity
@Table(name = "U_STAFF_MEMBER")
@XmlRootElement
public class StaffMember extends AbstractPerson{
	 
	/*
	@Column(name = "JOB_NAME")
	@Enumerated(EnumType.STRING)
	@NotFound(action = NotFoundAction.IGNORE)
	private JobType gender;
	*/
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private LoginProfile loginProfile;
	/*
	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	*/
	public LoginProfile getLoginProfile() {
		return loginProfile;
	}

	public void setLoginProfile(LoginProfile loginProfile) {
		this.loginProfile = loginProfile;
	}
	
	
}
