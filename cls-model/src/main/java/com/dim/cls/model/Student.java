package com.dim.cls.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


public class Student   {

	/*
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "LEARNING_SUBCRIPTION_R", joinColumns = { 
			@JoinColumn(name = "ID_INTERNAL", nullable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "ID_INTERNAL_SUB", 
					nullable = false) })
	private Subscription[] learningSubscriptions;
	
	public Subscription[] getLearningSubscriptions() {
		return learningSubscriptions;
	}

	public void setLearningSubscriptions(Subscription[] learningSubscriptions) {
		this.learningSubscriptions = learningSubscriptions;
	}
	*/
}
