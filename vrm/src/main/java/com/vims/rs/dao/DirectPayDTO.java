package com.vims.rs.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "directpay")
public class DirectPayDTO {

	@Id
	private String payment_id;
	private String policy_id;
	private String premium_amount;
	private Date due_date;
	private Date payment_date;
	private String payment_mode;
	private String amount_paid;
	public String getPolicyId() {
		return policy_id;
	}
	public void setPolicyId(String policyId) {
		this.policy_id = policyId;
	}
	public String getPremiumAmount() {
		return premium_amount;
	}
	public void setPremiumAmount(String premiumAmount) {
		this.premium_amount = premiumAmount;
	}
	public Date getDueDate() {
		return due_date;
	}
	public void setDueDate(Date dueDate) {
		this.due_date = dueDate;
	}
	public Date getPaymentDate() {
		return payment_date;
	}
	public void setPaymentDate(Date paymentDate) {
		this.payment_date = paymentDate;
	}
	public String getPaymentMode() {
		return payment_mode;
	}
	public void setPaymentMode(String paymentMode) {
		this.payment_mode = paymentMode;
	}
	public String getAmountPaid() {
		return amount_paid;
	}
	public void setAmountPaid(String amountPaid) {
		this.amount_paid = amountPaid;
	}
	public String getPaymentId() {
		return payment_id;
	}
	public void setPaymentId(String paymentId) {
		this.payment_id = paymentId;
	}
	public DirectPayDTO(String policyId, String premiumAmount, Date dueDate, Date paymentDate, String paymentMode,
			String amountPaid, String paymentId) {
		super();
		this.policy_id = policyId;
		this.premium_amount = premiumAmount;
		this.due_date = dueDate;
		this.payment_date = paymentDate;
		this.payment_mode = paymentMode;
		this.amount_paid = amountPaid;
		this.payment_id = paymentId;
	}
	public DirectPayDTO(){
		
	}
	
}
