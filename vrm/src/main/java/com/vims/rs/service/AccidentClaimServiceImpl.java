package com.vims.rs.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vims.rs.dao.AccidentClaimDTO;
import com.vims.rs.dao.AccidentClaimRepository;
import com.vims.rs.model.AccidentClaim;


@Service
public class AccidentClaimServiceImpl implements AccidentClaimService {

	@Autowired
	 DataSource dataSource;
	
	
	@Autowired
	AccidentClaimRepository  accidentClaimRep;
public List<AccidentClaim> getAllAccidentClaim() {
		
		List<AccidentClaim> list = new ArrayList<AccidentClaim>();
		
		for(AccidentClaimDTO claimDto : accidentClaimRep.getAllAccidentClaim()) {
			AccidentClaim ac=new AccidentClaim();
			ac.setPolicy_id(claimDto.getPolicy_id());
			ac.setClaim_id(claimDto.getClaim_id());
			ac.setUsername(claimDto.getUsername());
			ac.setTotal_amount(claimDto.getTotal_amount());
			ac.setAccident_type(claimDto.getAccident_type());
			ac.setWeightage(claimDto.getWeightage());
			
			list.add(ac);
			
		
		}
		
		return list;
	}

	public List<AccidentClaim> getAccidentClaimBySearchTerm(String searchTerm) {
		
		List<AccidentClaim> list = new ArrayList<AccidentClaim>();
		
		for(AccidentClaimDTO claimDto : accidentClaimRep.findByPolicy_id(searchTerm)) {
			AccidentClaim ac=new AccidentClaim();
			ac.setPolicy_id(claimDto.getPolicy_id());
			ac.setClaim_id(claimDto.getClaim_id());
			ac.setUsername(claimDto.getUsername());
			ac.setTotal_amount(claimDto.getTotal_amount());
			ac.setAccident_type(claimDto.getAccident_type());
			ac.setWeightage(claimDto.getWeightage());
			
			
			list.add(ac);
		}
		
		return list;
	}

	public void deleteAccidentClaim(String searchTerm) {
		accidentClaimRep.deleteAccidentClaim(searchTerm);
		
	}
}
