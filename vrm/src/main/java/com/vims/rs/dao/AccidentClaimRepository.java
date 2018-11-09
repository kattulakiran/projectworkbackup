package com.vims.rs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccidentClaimRepository extends JpaRepository<AccidentClaimDTO,Long>{

	@Query(nativeQuery = true)
	public List<AccidentClaimDTO> findByPolicy_id(@Param("searchTerm") String searchTerm);
	@Query(nativeQuery = true)
	public List<AccidentClaimDTO> getAllAccidentClaim();
	@Query(nativeQuery = true)
	public String getClaimId();
	@Query(nativeQuery = true)
	public void deleteAccidentClaim(@Param("searchTerm") String searchTerm);
}
