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

import com.vims.rs.dao.DircetPayRepository;
import com.vims.rs.dao.DirectPayDTO;
import com.vims.rs.dao.PaymentIdGenerator;
import com.vims.rs.exception.AllfieldsMandatory;
import com.vims.rs.exception.InvalidDetailsException;
import com.vims.rs.model.DirectPay;
import com.vims.rs.service.DirectPayService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(DirectPayRestURI.ROOT)
@Api("Operations to manage Direct Payments.")

public class DirectPayController {  
private static final Logger logger = LoggerFactory.getLogger(DirectPayController.class);
	
	Map<Integer, DirectPay> PolicyData = new HashMap<Integer, DirectPay>();
	
	@Autowired
	DirectPayService directpayService;
	
	@Autowired
	DircetPayRepository directpayRep;
	
	
	@ApiOperation(value="To get the payment details based on id provided.",response=DirectPay.class)
	@RequestMapping(value=DirectPayRestURI.SEARCH_POLICY,method = RequestMethod.GET)
	public List<DirectPay> searchPolicyid(@PathVariable("searchterm") String searchTerm) {
   		logger.info("Start searchPolicyid. searchterm="+searchTerm);
   		List<DirectPay> list = directpayService.findBypolicyId(searchTerm);
   		if (list.size()==0) throw new VehicleNotFound(searchTerm);
   		return list;
   		
   	}
	
	
	 @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved list"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    }
	    )
	 
	 @ApiOperation(value = "View a list of available policies", response = List.class)
		@RequestMapping(value = DirectPayRestURI.GET_ALL_DIRECTPAYMENT_DETAILS, method = RequestMethod.GET)
		public List getAllPaymentDetails() {
			logger.info("Start getAllpaymentdetails.");	
			System.out.println("get All policy Starts");
			List<DirectPay>  list = directpayService.getAllPaymentDetails();
			System.out.println("get All policyends Ends");
	   		return list;
		}
	
	 @ApiOperation(value = "Create a new Policy.", response = DirectPay.class)
	    @RequestMapping(value = DirectPayRestURI.CREATE_POLICY, method = RequestMethod.POST)
	    public DirectPay createPolicy(@RequestBody DirectPay directpay) {
	        logger.info("Start createPolicy.");
	        
	       if((directpay.getPolicyId()==null )){
                throw new AllfieldsMandatory("policy id");
	        }
	        if((directpay.getPremiumAmount()==null )){
                throw new AllfieldsMandatory("premium amount");
	        } 
	        if((directpay.getDueDate()==null )){
                throw new AllfieldsMandatory("due date");
	        } 
	        if((directpay.getPaymentDate()==null )){
                throw new AllfieldsMandatory("payment date");
	        } 
	        if((directpay.getPaymentMode()==null )){
                throw new AllfieldsMandatory("payment mode");
	        } 
	        if((directpay.getAmountPaid()==null )){
                throw new AllfieldsMandatory("Amount paid");
	        } 
	       
	       
	        if(!(directpay.getPremiumAmount().matches("[0-9'.']+"))){
                throw new InvalidDetailsException("Premium Amount");
	       } 
	        if(!(directpay.getAmountPaid().matches("[0-9'.']+"))){
                throw new InvalidDetailsException("Amount Paid");
	       } 
	        
	      /*  if(directpay.getPaymentDate().after(directpay.getDueDate())){
	        	throw new InvalidDetailsException("payment date is after due date so");
	        }*/
	        DirectPayDTO directpayDto = new DirectPayDTO();
	        
	        directpayDto.setPolicyId(directpay.getPolicyId());
	        directpayDto.setPremiumAmount(directpay.getPremiumAmount());
	        directpayDto.setDueDate(directpay.getDueDate());
	        directpayDto.setPaymentDate(directpay.getPaymentDate());
	        directpayDto.setPaymentMode(directpay.getPaymentMode());
	        directpayDto.setAmountPaid(directpay.getAmountPaid());
	        directpay.setPaymentId(PaymentIdGenerator.sequenceGenerator());
	        directpayDto.setPaymentId(directpay.getPaymentId());
	       	
	        directpayRep.save(directpayDto);
	        return directpay;
	        

	    }
	

	public void validateCustomer(String searchTerm) {
		if (PolicyData.get(searchTerm) == null) throw new VehicleNotFound(searchTerm);
	}

}
