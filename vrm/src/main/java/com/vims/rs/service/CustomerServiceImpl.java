package com.vims.rs.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vims.rs.dao.CustomerDTO;
import com.vims.rs.dao.CustomerRepository;
import com.vims.rs.model.Customer_details;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	
	@Autowired
	 DataSource dataSource;
	
	
	@Autowired
	CustomerRepository customerRep;

	public List<Customer_details> getAllCustomers() {
		
		List<Customer_details> list = new ArrayList<Customer_details>();
		
		for(CustomerDTO customerDto : customerRep.getAllCustomers()) {
			Customer_details cd=new Customer_details();
			cd.setName(customerDto.getName());
			cd.setPassword(customerDto.getPassword());
			cd.setAddress(customerDto.getAddress());
			cd.setCity(customerDto.getCity());
			cd.setState(customerDto.getState());
			cd.setPincode(customerDto.getPincode());
			cd.setEmail_address(customerDto.getEmail_address());
			cd.setGender(customerDto.getGender());
			cd.setContact_no(customerDto.getContact_no());
			cd.setDateofbirth(customerDto.getDateofbirth());
			cd.setCustomer_id(customerDto.getCustomer_id());
			cd.setCountry(customerDto.getCountry());
			list.add(cd);
			
		
		}
		
		return list;
	}

	public List<Customer_details> getCustomerBySearchTerm(String searchTerm) {
		
		List<Customer_details> list = new ArrayList<Customer_details>();
		for(CustomerDTO customerDto : customerRep.findByCustomer_id(searchTerm))  {
			Customer_details cd=new Customer_details();
			cd.setName(customerDto.getName());
			cd.setPassword(customerDto.getPassword());
			cd.setAddress(customerDto.getAddress());
			cd.setCity(customerDto.getCity());
			cd.setState(customerDto.getState());
			cd.setPincode(customerDto.getPincode());
			cd.setEmail_address(customerDto.getEmail_address());
			cd.setGender(customerDto.getGender());
			cd.setContact_no(customerDto.getContact_no());
			cd.setDateofbirth(customerDto.getDateofbirth());
			cd.setCustomer_id(customerDto.getCustomer_id());
			cd.setCountry(customerDto.getCountry());
			list.add(cd);
			
		
		}
		
		return list;
	}
		
		
//	public List<Vehicle_details> deleteVehicle(String searchTerm) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	

}