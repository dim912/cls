package com.dim.cls.model;

import com.dim.cls.util.BilCycleTypes;

public class Subject {

	private String name;
	private int grade;
	private int charge;
	private int discount;
	private int discountPercentage;
	private BilCycleTypes bilCycleType;
	private int admissionFee;
	private int admissionDiscount;
	private int admissionDiscountPercentage;
	
	public int getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public int getAdmissionFee() {
		return admissionFee;
	}
	public void setAdmissionFee(int admissionFee) {
		this.admissionFee = admissionFee;
	}
	public int getAdmissionDiscount() {
		return admissionDiscount;
	}
	public void setAdmissionDiscount(int admissionDiscount) {
		this.admissionDiscount = admissionDiscount;
	}
	public int getAdmissionDiscountPercentage() {
		return admissionDiscountPercentage;
	}
	public void setAdmissionDiscountPercentage(int admissionDiscountPercentage) {
		this.admissionDiscountPercentage = admissionDiscountPercentage;
	}

	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public BilCycleTypes getBilCycleType() {
		return bilCycleType;
	}
	public void setBilCycleType(BilCycleTypes bilCycleType) {
		this.bilCycleType = bilCycleType;
	}
	
}
