package com.vims.rs.service;

import java.util.List;

import com.vims.rs.model.TheftClaim;



public interface TheftClaimService {

	public List<TheftClaim> getAllTheftClaim();
	public List<TheftClaim> getTheftClaimBySearchTerm(String searchTerm);
}
