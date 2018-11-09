package com.vims.rs.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Register_pay")
public class Register_pay implements Serializable{
	private static final long serialVersionUID = -7788619177798333712L;
	

	@ApiModelProperty(notes = "Unique Id of the policy.", required = true)
	private String policy_id;
	@ApiModelProperty(notes = "Amount of the policy.", required = true)
	private String premium_amount;
	@ApiModelProperty(notes = "Unique Id of the policy.", required = true)
	private Date due_date;
	@ApiModelProperty(notes = "Due Date of the policy.", required = true)
	private Date current_date;
	@ApiModelProperty(notes = "Current Date of the policy.", required = true)
	private String payment_mode;
	@ApiModelProperty(notes = "Payment Mode of the policy.", required = true)
	private String amount_paid;
	@ApiModelProperty(notes = "Payment Id of the policy.", required = true)
	private String payment_id;
	
	
	
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
	
	@JsonSerialize(using=DateSerializer.class)
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
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	
	
}
