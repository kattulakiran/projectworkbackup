package com.vims.rs.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accidentclaim")
public class AccidentClaimDTO {

	@Id
	private String claim_id;
	private String policy_id;
	private String username;
	private int total_amount;
	private String accident_type;
	private int weightage;
	public AccidentClaimDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccidentClaimDTO(String policy_id, String claim_id, String username, int total_amount, String accident_type,
			int weightage) {
		super();
		this.policy_id = policy_id;
		this.claim_id = claim_id;
		this.username = username;
		this.total_amount = total_amount;
		this.accident_type = accident_type;
		this.weightage = weightage;
	}
	public String getPolicy_id() {
		return policy_id;
	}
	public void setPolicy_id(String policy_id) {
		this.policy_id = policy_id;
	}
	public String getClaim_id() {
		return claim_id;
	}
	public void setClaim_id(String claim_id) {
		this.claim_id = claim_id;
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
	public String getAccident_type() {
		return accident_type;
	}
	public void setAccident_type(String accident_type) {
		this.accident_type = accident_type;
	}
	public int getWeightage() {
		return weightage;
	}
	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}
	
	
}
