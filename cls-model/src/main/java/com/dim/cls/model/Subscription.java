package com.dim.cls.model;

import java.sql.Date;

import com.dim.cls.util.SubscriptionTypes;

public class Subscription {

	private Subject subject;
	private Date startDate;
	private Date endDate;
	private int charge;
	private int discount;
	private int discountPercentage;
	private int admissionFee;
	private int admissionDiscount;
	private int admissionDiscountPercentage;
	private Date billCStartDate;
	private Date billCEndDate;
	private boolean rentalStatus;
	
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
	private SubscriptionTypes subscriptionType;
	public Date getBillCStartDate() {
		return billCStartDate;
	}
	public void setBillCStartDate(Date billCStartDate) {
		this.billCStartDate = billCStartDate;
	}
	public Date getBillCEndDate() {
		return billCEndDate;
	}
	public void setBillCEndDate(Date billCEndDate) {
		this.billCEndDate = billCEndDate;
	}
	public boolean isRentalStatus() {
		return rentalStatus;
	}
	public void setRentalStatus(boolean rentalStatus) {
		this.rentalStatus = rentalStatus;
	}
	
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public SubscriptionTypes getSubscriptionType() {
		return subscriptionType;
	}
	public void setSubscriptionType(SubscriptionTypes subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
}
