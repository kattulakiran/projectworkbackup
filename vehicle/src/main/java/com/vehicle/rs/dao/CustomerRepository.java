package com.vehicle.rs.dao;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vehicle.rs.model.Customer_details;

public interface CustomerRepository extends JpaRepository<CustomerDTO,Long>{
	
	@Query(nativeQuery = true)
	public List<CustomerDTO> findByCustomer_id(@Param("searchTerm") String searchTerm);
	@Query(nativeQuery = true)
	public List<CustomerDTO> getAllCustomers();
	
	
//	@Query(nativeQuery = true)
//	public List<CustomerDTO> deleteCustomer(@Param("searchTerm") String searchTerm);
	
	
	

}