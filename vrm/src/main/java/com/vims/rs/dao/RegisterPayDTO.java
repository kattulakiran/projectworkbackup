package com.vims.rs.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="register_pay")


public class RegisterPayDTO {
	
	@Id
	private String payment_id;
	private String policy_id;
	private String premium_amount;
	private Date due_date;
	@Column(name="paid_date")
	private Date current_date;
	private String payment_mode;
	
	
	
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	public String getPolicy_id() {
		return policy_id;
	}
	public void setPolicy_id(String policy_id) {
		this.policy_id = policy_id;
	}
	public String getPremium_amount() {
		return premium_amount;
	}
	public void setPremium_amount(String premium_amount) {
		this.premium_amount = premium_amount;
	}
	
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public Date getCurrent_date() {
		return current_date;
	}
	public void setCurrent_date(Date current_date) {
		this.current_date = current_date;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public String getAmount_paid() {
		return amount_paid;
	}
	public void setAmount_paid(String amount_paid) {
		this.amount_paid = amount_paid;
	}
	private String amount_paid;


	public RegisterPayDTO(String policy_id, String premium_amount, Date due_date, Date current_date,
			String payment_mode, String amount_paid,String payment_id) {
		super();
		this.policy_id = policy_id;
		this.premium_amount = premium_amount;
		this.due_date = due_date;
		this.current_date = current_date;
		this.payment_mode = payment_mode;
		this.amount_paid = amount_paid;
		this.payment_id=payment_id;
	}

	
	 public RegisterPayDTO() {
			
		}


}
