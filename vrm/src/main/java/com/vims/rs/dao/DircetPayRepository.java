package com.vims.rs.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface DircetPayRepository extends JpaRepository<DirectPayDTO,Long> {	 

	@Query(nativeQuery = true)
	public List<DirectPayDTO> findBypolicyId(@Param("searchTerm") String searchTerm);

	@Query(nativeQuery = true)
	public List<DirectPayDTO> getAllPaymentDetails();
	}


