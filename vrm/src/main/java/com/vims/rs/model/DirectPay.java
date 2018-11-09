package com.vims.rs.model;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class DirectPay implements Serializable{
	
	private static final long serialVersionUID = -7788619177798333712L;
	
	@ApiModelProperty(notes = "Unique Id of the policy.", required = true)
    private String policy_id;
	@ApiModelProperty(notes = "fixed premium amount to be paid", required = true)
    private String premium_amount;
	@ApiModelProperty(notes = "Due date of the policy", required = true)
    private Date due_date;
	@ApiModelProperty(notes = "date on which payment is done", required = true)
    private Date payment_date;
	@ApiModelProperty(notes = "Mode of payment", required = true)
    private String payment_mode;
	@ApiModelProperty(notes = "Amount paid by the customer", required = true)
    private String amount_paid;
	@ApiModelProperty(notes = "Unique paymentId generated.", required = true)
    private String payment_id;
	
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
	
	public DirectPay(String policyId, String premiumAmount, Date dueDate, Date paymentDate, String paymentMode, String amountPaid,
			String paymentId) {
		super();
		this.policy_id = policyId;
		this.premium_amount = premiumAmount;
		this.due_date = dueDate;
		this.payment_date = paymentDate;
		this.payment_mode = paymentMode;
		this.amount_paid = amountPaid;
		this.payment_id = paymentId;
	}
	public DirectPay(){
		
	}

}
