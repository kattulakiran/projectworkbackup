package com.vims.rs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface CancellationRepository extends JpaRepository<CancellationDTO,Long>{
	
	@Query(nativeQuery = true)
	public List<CancellationDTO> findByPolicy_id(@Param("searchTerm") String searchTerm);
	@Query(nativeQuery = true)
	public List<CancellationDTO> getAllVehicles();


}
