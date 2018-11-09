package com.vims.rs.service;

import java.util.List;

import com.vims.rs.model.AccidentClaim;


public interface AccidentClaimService {

	public List<AccidentClaim> getAllAccidentClaim();
	public List<AccidentClaim> getAccidentClaimBySearchTerm(String searchTerm);
	public void deleteAccidentClaim(String searchTerm);
}
