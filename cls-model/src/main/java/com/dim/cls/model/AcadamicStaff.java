package com.dim.cls.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

//@Entity
public class AcadamicStaff extends StaffMember {

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "EXPERIANCED_SUBJECTS_R", joinColumns = { 
			@JoinColumn(name = "PERSON_ID", nullable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "SUBJECT_ID", 
					nullable = false) })
	private List<Subject> experiancedSubjects;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "EXPERIANCED_SUBJECTS_R", joinColumns = { 
			@JoinColumn(name = "PERSON_ID", nullable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "SUBJECT_ID", 
					nullable = false) })
	private List<Subscription> teachingSubscriptions;
	
	
	private List<Institute> otherTeachingInstitutes;
	
	public List<Subject> getExperiancedSubjects() {
		return experiancedSubjects;
	}
	
	
	public void setExperiancedSubjects(List<Subject> experiancedSubjects) {
		this.experiancedSubjects = experiancedSubjects;
	}
	public List<Subscription> getTeachingSubscriptions() {
		return teachingSubscriptions;
	}
	public void setTeachingSubscriptions(List<Subscription> teachingSubscriptions) {
		this.teachingSubscriptions = teachingSubscriptions;
	}
	public List<Institute> getOtherTeachingInstitutes() {
		return otherTeachingInstitutes;
	}
	public void setOtherTeachingInstitutes(List<Institute> otherTeachingInstitutes) {
		this.otherTeachingInstitutes = otherTeachingInstitutes;
	}
	
}