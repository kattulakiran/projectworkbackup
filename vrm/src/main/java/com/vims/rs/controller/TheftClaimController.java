package com.vims.rs.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vims.rs.dao.SequenceGenerator;
import com.vims.rs.dao.TheftClaimDTO;
import com.vims.rs.dao.TheftClaimRepository;
import com.vims.rs.exception.ClaimNotFoundException;
import com.vims.rs.exception.InvalidDetailsException;
import com.vims.rs.model.TheftClaim;
import com.vims.rs.service.TheftClaimService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(TheftClaimRestURIs.ROOT)
@Api("Operations to manage claim.")
public class TheftClaimController {
private static final Logger logger = LoggerFactory.getLogger(TheftClaimController.class);
	
	Map<Integer, TheftClaim> vehicleData = new HashMap<Integer, TheftClaim>();
	
	@Autowired
	TheftClaimService theftClaimService;
	
	@Autowired
	TheftClaimRepository theftClaimRep;
	
	
	@ApiOperation(value="To get the vehicle details based on id provided.",response=TheftClaim.class)
	@RequestMapping(value=TheftClaimRestURIs.SEARCH_THEFTCLAIM,method = RequestMethod.GET)
	public List<TheftClaim> searchTheftClaim(@PathVariable("searchterm") String searchTerm) {
   		logger.info("Start searchThefttClaim. searchterm="+searchTerm);
   		List<TheftClaim> list = theftClaimService.getTheftClaimBySearchTerm(searchTerm);
   		if (list.size()==0) throw new ClaimNotFoundException(searchTerm);
   		return list;
   		
   	}
	
	
	 @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved list"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    }
	    )
	 
	 @ApiOperation(value = "View a list of available AccidentClaim", response = List.class)
		@RequestMapping(value =TheftClaimRestURIs.GET_ALL_THEFTCLAIM, method = RequestMethod.GET)
		public List getAllTheftClaim() {
			logger.info("Start getAllTheftClaim.");	
			System.out.println("get All TheftClaim Starts");
			List<TheftClaim>  list = theftClaimService.getAllTheftClaim();
			System.out.println("get All TheftClaim Ends");
	   		return list;
		}
	
	 @ApiOperation(value = "Create a new TheftClaim.", response = TheftClaim.class)
	    @RequestMapping(value = TheftClaimRestURIs.CREATE_THEFTCLAIM, method = RequestMethod.POST)
	    public TheftClaim createTheftClaim(@RequestBody TheftClaim claim) {
	        logger.info("Start TheftClaim.");
	        if(claim.getUsername()==""){
	        	throw new InvalidDetailsException("username must ");
	        }
	        if(claim.getDate_of_complaint()==null){
	        	throw new InvalidDetailsException(" date of complaint");
	        }
	        if(claim.getDate_of_theft()==null){
	        	throw new InvalidDetailsException(" date of theft");
	        }
	        if(claim.getPolicy_id()==""){
	        	throw new InvalidDetailsException(" policy id");
	        }
	        
	        if(claim.getFir_number()==""||claim.getFir_number().length()>10){
	        	throw new InvalidDetailsException(" fir number, fire number not should be more than 10 letters");
	        }
	        if(claim.getPolice_station_branch()==""){
	        	throw new InvalidDetailsException(" police station branch");
	        }
	        Date d1=claim.getDate_of_theft();
	        Date d2=claim.getDate_of_complaint();
	        Calendar cal=Calendar.getInstance();
	        cal.setTime(d1);long l1=cal.getTimeInMillis();
	        cal.setTime(d2);long l2=cal.getTimeInMillis();
	        long diff=(l2-l1)/(60*60*24*1000);
	        if(diff>10){
	        	throw new InvalidDetailsException("difference between dates is more");
	        }
	        TheftClaimDTO claimDto = new TheftClaimDTO();
	        claimDto.setPolicy_id(claim.getPolicy_id());
	       claimDto.setFir_number(claim.getFir_number());
	       claim.setClaim_id(SequenceGenerator.sequenceGenerator());
	        claimDto.setTotal_amount(claim.getTotal_amount()*75/100);
	        claimDto.setDate_of_theft(claim.getDate_of_theft());
	        claimDto.setDate_of_complaint(claim.getDate_of_complaint());
	      claimDto.setUsername(claim.getUsername());
	        claimDto.setPolice_station_branch(claim.getPolice_station_branch());
	        claimDto.setClaim_id(claim.getClaim_id());
	        theftClaimRep.save(claimDto);
	        return claim;
	        

	    }
	
	 @ApiOperation(value = "UPDATE TheftClaim.", response = TheftClaim.class)
	    @RequestMapping(value = TheftClaimRestURIs.UPDATE_THEFTCLAIM, method = RequestMethod.PUT)
	    public TheftClaim updateTheftClaim(@RequestBody TheftClaim claim){
		 
		 TheftClaimDTO claimDto = new TheftClaimDTO();
	        claimDto.setPolicy_id(claim.getPolicy_id());
	       claimDto.setFir_number(claim.getFir_number());
	        claimDto.setTotal_amount(claim.getTotal_amount());
	        claimDto.setDate_of_theft(claim.getDate_of_theft());
	        claimDto.setDate_of_complaint(claim.getDate_of_complaint());
	      claimDto.setUsername(claim.getUsername());
	        claimDto.setPolice_station_branch(claim.getPolice_station_branch());
	        claimDto.setClaim_id(claim.getClaim_id());
	        theftClaimRep.save(claimDto);
	        return claim;
		
	 }
}
