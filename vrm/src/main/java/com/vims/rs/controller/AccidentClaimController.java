package com.vims.rs.controller;

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

import com.vims.rs.dao.AccidentClaimDTO;
import com.vims.rs.dao.AccidentClaimRepository;
import com.vims.rs.dao.SequenceGenerator;
import com.vims.rs.exception.ClaimNotFoundException;
import com.vims.rs.exception.InvalidDetailsException;
import com.vims.rs.model.AccidentClaim;
import com.vims.rs.service.AccidentClaimService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(AccidentClaimRestURIs.ROOT)
@Api("Operations to manage claim.")
public class AccidentClaimController {

private static final Logger logger = LoggerFactory.getLogger(AccidentClaimController.class);
	
	Map<Integer, AccidentClaim> vehicleData = new HashMap<Integer, AccidentClaim>();
	
	@Autowired
	AccidentClaimService accidentClaimService;
	
	@Autowired
	AccidentClaimRepository accidentClaimRep;
	
	
	@ApiOperation(value="To get the vehicle details based on id provided.",response=AccidentClaim.class)
	@RequestMapping(value=AccidentClaimRestURIs.SEARCH_ACCIDENTCLAIM,method = RequestMethod.GET)
	public List<AccidentClaim> searchAccidentClaim(@PathVariable("searchterm") String searchTerm) {
   		logger.info("Start searchAccidentClaim. searchterm="+searchTerm);
   		List<AccidentClaim> list = accidentClaimService.getAccidentClaimBySearchTerm(searchTerm);
//   		if (list.size()==0) throw new AccidentClaimNotFound(searchTerm);
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
		@RequestMapping(value = AccidentClaimRestURIs.GET_ALL_ACCIDENTCLAIM, method = RequestMethod.GET)
		public List getAllAccidentClaim() {
			logger.info("Start getAllAccidentClaim.");	
			System.out.println("get All AccidentClaim Starts");
			List<AccidentClaim>  list = accidentClaimService.getAllAccidentClaim();
			System.out.println("get All AccidentClaim Ends");
	   		return list;
		}
	
	 @ApiOperation(value = "Create a new AccidentClaim.", response = AccidentClaim.class)
	    @RequestMapping(value = AccidentClaimRestURIs.CREATE_ACCIDENTCLAIM, method = RequestMethod.POST)
	    public AccidentClaim createAccidentClaim(@RequestBody AccidentClaim claim) {
	        logger.info("Start AccidentClaim.");
	        if(claim.getAccident_type()==""){
	        	throw new InvalidDetailsException("accident type");
	        }
	        
	        if(claim.getPolicy_id()==""){
	        	throw new InvalidDetailsException("policy id");
	        }
	        if(claim.getTotal_amount()==0){
	        	throw new InvalidDetailsException("total amount");
	        }
	        if(claim.getUsername()==""){
	        	throw new InvalidDetailsException("user name");
	        }
	        
//	       if(claim.getClaim_id()== accidentClaimRep.getClaimId()){
//	    	   throw new ClaimedException("claim already exists");
//	       }
	        AccidentClaimDTO claimDto = new AccidentClaimDTO();
	        claimDto.setPolicy_id(claim.getPolicy_id());
	        claim.setClaim_id(SequenceGenerator.sequenceGenerator());
	        claimDto.setClaim_id(claim.getClaim_id());
	        claimDto.setUsername(claim.getUsername());
	        String type=claim.getAccident_type();
	        if(type.equalsIgnoreCase("fire")){
	        	claim.setWeightage(80);
	        }else if(type.equalsIgnoreCase("road accident")){
	        	claim.setWeightage(70);
	        }
	        else if(type.equalsIgnoreCase("malicious acts")){
	        	claim.setWeightage(50);
	        }else if(type.equalsIgnoreCase("self-destruction")){
	        	claim.setWeightage(40);
	        }else if(type.equalsIgnoreCase("part failure")){
	        	claim.setWeightage(20);
	        }
	        claimDto.setTotal_amount(claim.getTotal_amount()*claim.getWeightage()/100);
	        claimDto.setAccident_type(claim.getAccident_type());
	        claimDto.setWeightage(claim.getWeightage());
	        claim.setTotal_amount(claimDto.getTotal_amount());
	        accidentClaimRep.save(claimDto);
	        return claim;

	    }
	
	 @ApiOperation(value = "update the AccidentClaim.", response = AccidentClaim.class)
	    @RequestMapping(value = AccidentClaimRestURIs.UPDATE_ACCIDENTCLAIM, method = RequestMethod.PUT)
	    public AccidentClaim updateAccidentClaim(@PathVariable("searchterm") String searchTerm,@RequestBody AccidentClaim claim){
		if(accidentClaimRep.findByPolicy_id(searchTerm).size()==0){
			throw new ClaimNotFoundException(searchTerm);
		}
		 for(AccidentClaimDTO claimDto : accidentClaimRep.findByPolicy_id(searchTerm)){
	        claimDto.setPolicy_id(claim.getPolicy_id());
	        claimDto.setClaim_id(claim.getClaim_id());
	        claimDto.setUsername(claim.getUsername());
	        claimDto.setWeightage(claim.getWeightage());
	        claimDto.setTotal_amount(claim.getTotal_amount());
	        claimDto.setAccident_type(claim.getAccident_type());
	       
	        accidentClaimRep.save(claimDto);
		 }
	        
	        return claim;
	 }
	 @ApiOperation(value="To delete the accident claim details based on id provided.",response=AccidentClaim.class)
		@RequestMapping(value=AccidentClaimRestURIs.DELETE_ACCIDENTCLAIM,method = RequestMethod.DELETE)
		public void deleteAccidentClaim(@PathVariable("searchterm") String searchTerm){
		 accidentClaimService.deleteAccidentClaim(searchTerm);
	 }

}
