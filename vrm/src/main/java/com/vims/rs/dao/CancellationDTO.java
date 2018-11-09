package com.vims.rs.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cancellation")

public class CancellationDTO {
	@Id
	private String cancel_id;
	private String customer_id;
	private String policy_id;
	private String total_amt;
	private Date registration_date;
	private Date last_paid_date;
	private Date cancelled_date;
	private String withdraw_amt;
	
	public CancellationDTO(String cancel_id, String customer_id, String policy_id, String total_amt,
			Date registration_date, Date last_paid_date, Date cancelled_date, String withdraw_amt) {
		super();
		this.cancel_id = cancel_id;
		this.customer_id = customer_id;
		this.policy_id = policy_id;
		this.total_amt = total_amt;
		this.registration_date = registration_date;
		this.last_paid_date = last_paid_date;
		this.cancelled_date = cancelled_date;
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
	
	
	
	public CancellationDTO(){
		
	}

}
