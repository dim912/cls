package com.dim.cls.model.abstracts;

import java.sql.Date;

import com.dim.cls.model.Student;
import com.dim.cls.model.Transaction;

public abstract class AbstractCharge {

	private Student student;
	private Date dtCreated;
	private Date originalCharge;
	private Date discount;
	private Date discountedCharge;
	private Date paymentStatus;
	private Transaction paidTrasaction;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Date getDiscount() {
		return discount;
	}
	public Date getDtCreated() {
		return dtCreated;
	}
	public void setDtCreated(Date dtCreated) {
		this.dtCreated = dtCreated;
	}
	public Date getOriginalCharge() {
		return originalCharge;
	}
	public void setOriginalCharge(Date originalCharge) {
		this.originalCharge = originalCharge;
	}
	public Date getDiscounte() {
		return discount;
	}
	public void setDiscount(Date discount) {
		this.discount = discount;
	}
	public Date getDiscountedCharge() {
		return discountedCharge;
	}
	public void setDiscountedCharge(Date discountedCharge) {
		this.discountedCharge = discountedCharge;
	}
	public Date getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(Date paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Transaction getPaidTrasaction() {
		return paidTrasaction;
	}
	public void setPaidTrasaction(Transaction paidTrasaction) {
		this.paidTrasaction = paidTrasaction;
	}
	
	
}
