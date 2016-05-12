package com.dim.cls.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.dim.cls.model.abstracts.AbstractPerson;
import com.dim.cls.util.GenderType;

@Entity
public class StaffMember extends AbstractPerson {
	
	/*
	@Column(name = "JOB_NAME")
	@Enumerated(EnumType.STRING)
	@NotFound(action = NotFoundAction.IGNORE)
	private JobType gender;
	*/
	@OneToOne
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
