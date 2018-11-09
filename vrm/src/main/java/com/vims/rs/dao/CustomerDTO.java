package com.vims.rs.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Table(name="customerdetails")

public class CustomerDTO {
	
	@Id
	private String customer_id;
	private String name;
	private String password;
	private String address;
	private String city;
	private String state;
	private String country;
	private String pincode;	
	private String email_address;
	private String gender;
	private String contact_no;
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
	
	
	public CustomerDTO(String name, String password, String address, String city,
	String state,String country,String pincode, String emailid,String gender,
	String contact_no,Date dateofbirth, String customer_id, String email_address) {
		
		super();
		this.name = name;
		this.password = password;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.email_address = email_address;
	    this.gender = gender;
		this.contact_no = contact_no;
		this.dateofbirth = dateofbirth;
		this.customer_id = customer_id;
	}
	
	public CustomerDTO() {
		
	}
	
	

}