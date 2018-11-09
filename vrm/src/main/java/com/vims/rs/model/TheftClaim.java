package com.vims.rs.model;

import java.util.Date;

public class TheftClaim {

	private String policy_id;
	private String username;
	private int total_amount;
	private Date date_of_theft;
	private Date date_of_complaint;
	private String fir_number;
	private String police_station_branch;
	private String claim_id;
	public String getPolicy_id() {
		return policy_id;
	}
	public void setPolicy_id(String policy_id) {
		this.policy_id = policy_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public Date getDate_of_theft() {
		return date_of_theft;
	}
	public void setDate_of_theft(Date date_of_theft) {
		this.date_of_theft = date_of_theft;
	}
	public Date getDate_of_complaint() {
		return date_of_complaint;
	}
	public void setDate_of_complaint(Date date_of_complaint) {
		this.date_of_complaint = date_of_complaint;
	}
	public String getFir_number() {
		return fir_number;
	}
	public void setFir_number(String fir_number) {
		this.fir_number = fir_number;
	}
	public String getPolice_station_branch() {
		return police_station_branch;
	}
	public void setPolice_station_branch(String police_station_branch) {
		this.police_station_branch = police_station_branch;
	}
	public String getClaim_id() {
		return claim_id;
	}
	public void setClaim_id(String claim_id) {
		this.claim_id = claim_id;
	}
	public TheftClaim(String policy_id, String username, int total_amount, Date date_of_theft, Date date_of_complaint,
			String fir_number, String police_station_branch, String claim_id) {
		super();
		this.policy_id = policy_id;
		this.username = username;
		this.total_amount = total_amount;
		this.date_of_theft = date_of_theft;
		this.date_of_complaint = date_of_complaint;
		this.fir_number = fir_number;
		this.police_station_branch = police_station_branch;
		this.claim_id = claim_id;
	}
	public TheftClaim() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
