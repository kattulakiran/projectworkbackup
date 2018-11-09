package com.vims.rs.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vims.rs.dao.PaymentIdGenerator;
import com.vims.rs.dao.RegisterPayDTO;
import com.vims.rs.dao.RegisterPayRepository;
import com.vims.rs.exception.RegisterPayException;
import com.vims.rs.model.Register_pay;
import com.vims.rs.service.RegisterPayService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(RegisterPayRestURIs.ROOT)
@Api("Operations to manage Vehicles.")
public class RegisterPayController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterPayController.class);
	@Autowired
	RegisterPayService payService;
	
	@Autowired
	RegisterPayRepository regPay;
	
	@ApiOperation(value="To get the vehicle details based on id provided.",response=Register_pay.class)
	@RequestMapping(value=RegisterPayRestURIs.SEARCH_VEHICLE,method = RequestMethod.GET)
	

	public List<Register_pay> searchVehicle(@PathVariable("searchterm") String searchTerm) {
   		logger.info("Start searchVehicle. searchterm="+searchTerm);
   		List<Register_pay> list = payService.getVehicleBySearchTerm(searchTerm);
   		return list;
	}
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
 
	 @ApiOperation(value = "View a list of available Vehicles", response = List.class)
	@RequestMapping(value = RegisterPayRestURIs.GET_ALL_VEHICLES, method = RequestMethod.GET)
	
	public List getAllEmployees() {
		logger.info("Start getAllVehicles.");	
		System.out.println("get All vehicles Starts");
		List<Register_pay>  list = payService.getAllVehicles();
		System.out.println("get All vehicles Ends");
   		return list;
	}
	
	 @ApiOperation(value = "Create a new Vehicle.", response = Register_pay.class)
	    @RequestMapping(value = RegisterPayRestURIs.CREATE_VEHICLE, method = RequestMethod.POST)
	 public Register_pay createVehicle(@RequestBody Register_pay pay) {
	        logger.info("Start createVehicle.");
	        logger.info("Start createVehicle.");
	        RegisterPayDTO payDto = new RegisterPayDTO();
	        payDto.setPolicy_id(pay.getPolicy_id());
	        
	        
	        String pa=pay.getPremium_amount();
	        if(!pa.matches("[0-9]{1,}")){
	        	throw new RegisterPayException("PremiumAmount");}
	        String pm=pay.getPayment_mode();
	        if(!pm.matches("[A-Za-z]{1,}")){
	        	throw new RegisterPayException("Payment Mode");
	        }
	        String ap=pay.getAmount_paid();
	        //if(!ap.matches("[0-9]{10}")){
	        //	throw new RegisterPayException("Amount Paid");}
	          double fap=0;
	        	 Date d1=pay.getDue_date();
	        		        Date d2=pay.getCurrent_date();
	        		        Calendar cal=Calendar.getInstance();
	        		        cal.setTime(d1);long l1=cal.getTimeInMillis();
	        		        cal.setTime(d2);long l2=cal.getTimeInMillis();
	        		        long diff=(l2-l1)/(60*60*24*1000); 
	        		        if(pay.getPayment_mode().toLowerCase()=="creditcard"){
	        		        fap=Long.parseLong(pa)*diff*0.0056*0.023;
	        		        }
	        		        else{
	        		        	 fap=Long.parseLong(pa)*diff*0.0056;
	        		        }
	        		        String fap1=String.valueOf(fap);
	        	 pay.setAmount_paid(fap1);
                 pay.setPayment_id(PaymentIdGenerator.sequenceGenerator());
	        payDto.setPremium_amount(pay.getPremium_amount());
	        payDto.setDue_date(pay.getDue_date());
	        payDto.setCurrent_date(pay.getCurrent_date());
	        payDto.setPayment_mode(pay.getPayment_mode());
	        payDto.setAmount_paid(pay.getAmount_paid());
	        payDto.setPayment_id(pay.getPayment_id());
	        
	        regPay.save(payDto);
	        return pay;
	 }
	 
	
}
