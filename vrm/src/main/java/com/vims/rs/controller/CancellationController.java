package com.vims.rs.controller;

import java.text.ParseException;
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

import com.vims.rs.dao.CancelIdGenerator;
import com.vims.rs.dao.CancellationDTO;
import com.vims.rs.dao.CancellationRepository;
import com.vims.rs.exception.CancellationException;
import com.vims.rs.model.Cancellation;
import com.vims.rs.service.CancellationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;






@RestController
@RequestMapping(CancellationRestURIs.ROOT)
@Api("Operations to manage Vehicles.")
public class CancellationController {
	
	private static final Logger logger = LoggerFactory.getLogger(CancellationController.class);
	@Autowired
	CancellationService canService;
	
	@Autowired
	CancellationRepository canRep;
	@ApiOperation(value="To get the vehicle details based on id provided.",response=Cancellation.class)
	@RequestMapping(value=CancellationRestURIs.SEARCH_VEHICLE,method = RequestMethod.GET)
	
	public List<Cancellation> searchVehicle(@PathVariable("searchterm") String searchTerm) {
   		logger.info("Start searchVehicle. searchterm="+searchTerm);
   		List<Cancellation> list = canService.getVehicleBySearchTerm(searchTerm);
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
		@RequestMapping(value = CancellationRestURIs.GET_ALL_VEHICLES, method = RequestMethod.GET)
		
		public List getAllEmployees() {
			logger.info("Start getAllVehicles.");	
			System.out.println("get All vehicles Starts");
			List<Cancellation>  list = canService.getAllVehicles();
			System.out.println("get All vehicles Ends");
	   		return list;
		}
	
	    @ApiOperation(value = "Create a new Vehicle.", response =   Cancellation.class)
	    @RequestMapping(value =   CancellationRestURIs.CREATE_VEHICLE, method = RequestMethod.POST)
	 public   Cancellation createVehicle(@RequestBody  Cancellation can) throws ParseException {
	        logger.info("Start createVehicle.");
	        logger.info("Start createVehicle.");
	       CancellationDTO canDto = new  CancellationDTO();
	       can.setCancel_id(CancelIdGenerator.sequenceGenerator());
	       Date s2=can.getCancelled_date();
	       Date s1=can.getLast_paid_date();
	
	       Calendar cal=Calendar.getInstance();
	       cal.setTime(s1);
	       int months1=cal.get(Calendar.MONTH);
	       int year1=cal.get(Calendar.YEAR);
	       cal.setTime(s2);
	       int months2=cal.get(Calendar.MONTH);
	       int year2=cal.get(Calendar.YEAR);
	       int n=((year2-year1)*12)+(months2-months1);
	       
	       Date s4=can.getCancelled_date();
	       Date s3=can.getRegistration_date();
	       Calendar cal1=Calendar.getInstance();
	       cal1.setTime(s3);
	       int mont1=cal1.get(Calendar.MONTH);
	       int yea1=cal1.get(Calendar.YEAR);
	       cal1.setTime(s4);
	       int mont2=cal1.get(Calendar.MONTH);
	       int yea2=cal1.get(Calendar.YEAR);
	       int m=((yea2-yea1)*12)+(mont2-mont1);
	       
	       if(n>3){
	    	   if(n>9){
	    		   String s=can.getTotal_amt();
	    		   long l= Long.parseLong(s);
	    		   double t=0;
	    		   String to=String.valueOf(t);
	    		   can.setWithdraw_amt(to);
	    	   }
	    	   else if(n==9){
	    		   String s=can.getTotal_amt();
	    		   long l= Long.parseLong(s);
	    		   double t=l-(l*0.1235);
	    		   String to=String.valueOf(t);
	    		   can.setWithdraw_amt(to);
	    		   
	    	   }
	    	   else if(n>=7){
	    		   String s=can.getTotal_amt();
	    		   long l= Long.parseLong(s);
	    		   double t=l-(l*0.1025);
	    		   String to=String.valueOf(t);
	    		   can.setWithdraw_amt(to);
	    		   
	    	   }
	    	   
	    	      else if(n>=5){
	    		   String s=can.getTotal_amt();
	    		   long l= Long.parseLong(s);
	    		   double t=l-(l*0.07);
	    		   String to=String.valueOf(t);
	    		   can.setWithdraw_amt(to);
	    	   }
	    	   
	    	  
	       }
	       else{
	    	   if(m>3){
	    		   String s=can.getTotal_amt();
	    		   long l= Long.parseLong(s);
	    		   double t=l-(l*0.1235);
	    		   String to=String.valueOf(t);
	    		   can.setWithdraw_amt(to);
	    	   }
	    	   else{
	    		   throw new CancellationException("Not Eligible for Cancellation");
	    	   }
	       }
	       
	       
	       canDto.setCancel_id(can.getCancel_id());
	       canDto.setCustomer_id(can.getCustomer_id());
	       canDto.setPolicy_id(can.getPolicy_id());
	       canDto.setTotal_amt(can.getTotal_amt());
	       canDto.setRegistration_date(can.getRegistration_date());
	       canDto.setLast_paid_date(can.getLast_paid_date());
	       canDto.setCancelled_date(can.getCancelled_date());
	       canDto.setWithdraw_amt(can.getWithdraw_amt());
	       canRep.save(canDto);
		    return can;

}
}
