package com.vims.rs.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<CustomerDTO,Long>{
	
	@Query(nativeQuery = true)
	public List<CustomerDTO> findByCustomer_id(@Param("searchTerm") String searchTerm);
	@Query(nativeQuery = true)
	public List<CustomerDTO> getAllCustomers();
	
	
//	@Query(nativeQuery = true)
//	public List<CustomerDTO> deleteCustomer(@Param("searchTerm") String searchTerm);
	
	
	

}