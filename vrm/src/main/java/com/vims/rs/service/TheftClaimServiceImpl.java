package com.vims.rs.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vims.rs.dao.TheftClaimDTO;
import com.vims.rs.dao.TheftClaimRepository;
import com.vims.rs.model.TheftClaim;

@Service
public class TheftClaimServiceImpl implements TheftClaimService{

	@Autowired
	 DataSource dataSource;
	@Autowired
	TheftClaimRepository  theftClaimRep;
public List<TheftClaim> getAllTheftClaim() {
		
		List<TheftClaim> list = new ArrayList<TheftClaim>();
		
		for(TheftClaimDTO claimDto : theftClaimRep.getAllTheftClaim()) {
			TheftClaim ac=new TheftClaim();
			ac.setPolicy_id(claimDto.getPolicy_id());
			ac.setUsername(claimDto.getUsername());
			ac.setTotal_amount(claimDto.getTotal_amount());
			ac.setDate_of_theft(claimDto.getDate_of_theft());
			ac.setDate_of_complaint(claimDto.getDate_of_complaint());
			ac.setFir_number(claimDto.getFir_number());
			ac.setPolice_station_branch(claimDto.getPolice_station_branch());
			ac.setClaim_id(claimDto.getClaim_id());
			
			list.add(ac);
		}
		
		return list;
	}

	public List<TheftClaim> getTheftClaimBySearchTerm(String searchTerm) {
		
		List<TheftClaim> list = new ArrayList<TheftClaim>();
		
		for(TheftClaimDTO claimDto : theftClaimRep.findByPolicy_id(searchTerm)) {
			TheftClaim ac=new TheftClaim();
			ac.setPolicy_id(claimDto.getPolicy_id());
			ac.setUsername(claimDto.getUsername());
			ac.setTotal_amount(claimDto.getTotal_amount());
			ac.setDate_of_theft(claimDto.getDate_of_theft());
			ac.setDate_of_complaint(claimDto.getDate_of_complaint());
			ac.setFir_number(claimDto.getFir_number());
			ac.setPolice_station_branch(claimDto.getPolice_station_branch());
			ac.setClaim_id(claimDto.getClaim_id());
			list.add(ac);
		}
		
		return list;
	}
}
