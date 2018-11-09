package com.vims.rs.service;

import java.util.List;

import com.vims.rs.model.Customer_details;

public interface CustomerService {

	public List<Customer_details> getAllCustomers();
	public List<Customer_details> getCustomerBySearchTerm(String searchTerm);
	//public List<Vehicle_details> deleteVehicle(String searchTerm);
	
	
}