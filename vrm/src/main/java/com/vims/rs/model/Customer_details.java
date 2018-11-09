package com.vims.rs.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Customer Details.")

public class Customer_details implements Serializable{
	
	private static final long serialVersionUID = -7788619177798333712L;
	
	
	@ApiModelProperty(notes = "Unique Id of the Customer.", required = true)
	private String customer_id;
	@ApiModelProperty(notes = "Name of the Customer.", required = true)
	private String name;
	@ApiModelProperty(notes = "Customer Password.", required = true)
	private String password;
	@ApiModelProperty(notes = "Address of the Customer.", required = true)
	private String address;
	@ApiModelProperty(notes = "Customer City.", required = true)
	private String city;
	@ApiModelProperty(notes = "Customer State.", required = true)
	private String state;
	@ApiModelProperty(notes = "Customer Country.", required = true)
	private String country;
	@ApiModelProperty(notes = "Pincode of the Customer.", required = true)
	private String pincode;
	@ApiModelProperty(notes = "Emailid of the Customer.", required = true)
	private String email_address;
	@ApiModelProperty(notes = "Gender of the Customer.", required = true)
	private String gender;
	@ApiModelProperty(notes = "Contactnumber of the Customer.", required = true)
	private String contact_no;
	@ApiModelProperty(notes = "Date of birth of the Customer.", required = true)
	private Date dateofbirth;
	
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode =pincode;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no =contact_no;
	}
	
	@JsonSerialize(using=DateSerializer.class)
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	
	

	
}