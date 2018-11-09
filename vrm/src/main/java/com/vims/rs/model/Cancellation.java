package com.vims.rs.model;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class Cancellation {
	@ApiModelProperty(notes = "Unique Id of the cancellation.", required = true)
	private String cancel_id;
	@ApiModelProperty(notes = "Unique Id of the customer.", required = true)
	private String customer_id;
	@ApiModelProperty(notes = "Unique Id of the policy", required = true)
	private String policy_id;
	@ApiModelProperty(notes = "Total amount of the policy.", required = true)
	private String total_amt;
	@ApiModelProperty(notes = "registration_date of the policy.", required = true)
	private Date registration_date;
	@ApiModelProperty(notes = "Last paid date of the policy.", required = true)
	private Date last_paid_date;
	@ApiModelProperty(notes = "cancelled date of the policy.", required = true)
	private Date cancelled_date;
	@ApiModelProperty(notes = "withdraw amount of the policy.", required = true)
	private String withdraw_amt;
	
	
	public String getCancel_id() {
		return cancel_id;
	}

	public void setCancel_id(String cancel_id) {
		this.cancel_id = cancel_id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getPolicy_id() {
		return policy_id;
	}
	public void setPolicy_id(String policy_id) {
		this.policy_id = policy_id;
	}
	public String getTotal_amt() {
		return total_amt;
	}
	public void setTotal_amt(String total_amt) {
		this.total_amt = total_amt;
	}
	
	
	public String getWithdraw_amt() {
		return withdraw_amt;
	}
	public void setWithdraw_amt(String withdraw_amt) {
		this.withdraw_amt = withdraw_amt;
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

	public Date getLast_paid_date() {
		return last_paid_date;
	}

	public void setLast_paid_date(Date last_paid_date) {
		this.last_paid_date = last_paid_date;
	}

	public Date getCancelled_date() {
		return cancelled_date;
	}

	public void setCancelled_date(Date cancelled_date) {
		this.cancelled_date = cancelled_date;
	}
	
}
