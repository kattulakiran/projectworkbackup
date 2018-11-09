package com.vims.rs.controller;

import java.text.SimpleDateFormat;
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

import com.vims.rs.dao.CustIdGenerator;
import com.vims.rs.dao.CustomerDTO;
import com.vims.rs.dao.CustomerRepository;
import com.vims.rs.exception.FieldsAreMandatoryException;
import com.vims.rs.exception.InvalidDetailsExceptions;
import com.vims.rs.model.Customer_details;
import com.vims.rs.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(CustomerRestURIs.ROOT)
@Api("Operations to manage Vehicles.")

public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	Map<Integer, Customer_details> customerData = new HashMap<Integer, Customer_details>();
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerRepository customerRep;
	
	
	@ApiOperation(value="To get the customer details based on id provided.",response=Customer_details.class)
	@RequestMapping(value=CustomerRestURIs.SEARCH_CUSTOMER,method = RequestMethod.GET)
	public List<Customer_details> searchCustomer(@PathVariable("searchterm") String searchTerm) {
   		logger.info("Start searchCustomer. searchterm="+searchTerm);
   		List<Customer_details> list = customerService.getCustomerBySearchTerm(searchTerm);
   		if (list.size()==0) throw new CustomerNotfound(searchTerm);
   		return list;
   		
   	}
	 
	
	 @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved list"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    }
	    )
	 
	 @ApiOperation(value = "View a list of available Customers", response = List.class)
		@RequestMapping(value = CustomerRestURIs.GET_ALL_CUSTOMERS, method = RequestMethod.GET)
		public List getAllCustomers() {
			logger.info("Start getAllCustomers.");	
			System.out.println("get All customers Starts");
			List<Customer_details>  list = customerService.getAllCustomers();
			System.out.println("get All vehicles Ends");
	   		return list;
		}
	
	 @ApiOperation(value = "Create a new Customer.", response = Customer_details.class)
	    @RequestMapping(value = CustomerRestURIs.CREATE_CUSTOMER, method = RequestMethod.POST)
	    public Customer_details createCustomer(@RequestBody Customer_details customer) {
	        logger.info("Start createCustomer.");
	        
	        if(customer.getName()==""){
                throw new FieldsAreMandatoryException("Name");
	        }
	        if(customer.getPassword()==""){
                throw new FieldsAreMandatoryException("Password");
	        }
	        if(customer.getAddress()==""){
                throw new FieldsAreMandatoryException("Address");
	        }

	        if(customer.getCity()==""){
                throw new FieldsAreMandatoryException("City");
	        }
	        if(customer.getState()==""){
                throw new FieldsAreMandatoryException("State");
	        }
	        if(customer.getCountry()==""){
                throw new FieldsAreMandatoryException("Country");
	        }
	        if(customer.getPincode()==""){
                throw new FieldsAreMandatoryException("Pincode");
	        }
	        if(customer.getEmail_address()==""){
                throw new FieldsAreMandatoryException("Email Address");
	        }
	        
	        if(customer.getGender()==""){
                throw new FieldsAreMandatoryException("Gender");
	        }
	        if(customer.getContact_no()==""){
                throw new FieldsAreMandatoryException("Contact Number");
	        }
	        
	        if(customer.getDateofbirth()==null){
                throw new FieldsAreMandatoryException("Age");
	        }
	        if(customer.getCustomer_id()==""){
                throw new FieldsAreMandatoryException("Customer Id");
	        }
        if(!customer.getName().matches("[a-zA-Z]{1,}")){
                throw new InvalidDetailsExceptions("Name");
	        }
	        
        if(!(customer.getPassword().matches(".*[0-9]{1,}.*") && customer.getPassword().matches(".*[A-Z]{1,}.*") && customer.getPassword().matches(".*[a-z]{1,}.*"))){
            throw new InvalidDetailsExceptions("Password");
        }
        if(!(customer.getPincode().length()==6 && customer.getPincode().matches("[0-9]{6}"))){
            throw new InvalidDetailsExceptions("Pincode");
        }
        if(!(customer.getContact_no().length()==10 && customer.getContact_no().matches("[0-9]{10}"))){
            throw new InvalidDetailsExceptions("Contact Number");
        }
        
        /*if((customer.getAddress().matches(".*[0-9]{1,}.*") && customer.getAddress().matches(".*[A-Z]{1,}.*") && customer.getAddress().matches(".*[a-z]{1,}.*"))){
            throw new InvalidDetailsException("Address");
        }*/
	        
	        
	      
	        if(!(customer.getAddress().matches(".*[a-zA-Z0-9' '].*") )){
                throw new InvalidDetailsExceptions("Address");
	        }
	        
	        if(!customer.getEmail_address().matches("[a-zA-z0-9'.''_']{1,}@[a-zA-z]{1,}.com")){
                throw new InvalidDetailsExceptions("email address");
                
	        }
	        long time1=customer.getDateofbirth().getTime();
	        SimpleDateFormat sdf = new SimpleDateFormat();
	        Date curr_date = new Date();
	        long now = curr_date.getTime();
	        long diff=now-time1;
	        long l1=(24 * 60 * 60 * 1000);
	        long l=l1*365;
	        long age=diff/l;
	        if(age>90)
	        	 throw new InvalidDetailsExceptions("age");
	        
	        
	        
	        CustomerDTO customerDto = new CustomerDTO();
	       // String Customer_id="2018"+"10"+"1000";
	        
	        customer.setCustomer_id(CustIdGenerator.sequenceGenerator());
	        customerDto.setCustomer_id(customer.getCustomer_id());
	        customerDto.setName(customer.getName());
	        customerDto.setPassword(customer.getPassword());
	        customerDto.setAddress(customer.getAddress());
	        customerDto.setCity(customer.getCity());
	        customerDto.setState(customer.getState());
	        customerDto.setCountry(customer.getCountry());
	        customerDto.setPincode(customer.getPincode());
	        customerDto.setEmail_address(customer.getEmail_address());
			customerDto.setGender(customer.getGender());
			customerDto.setContact_no(customer.getContact_no());
			customerDto.setDateofbirth(customer.getDateofbirth());
			
	        customerRep.save(customerDto);
	        return customer;
	        

	    }
	
	        
	 
	 
	 
     @ApiOperation(value = "update the CustomerDetails.", response = Customer_details.class)
     @RequestMapping(value = CustomerRestURIs.UPDATE_CUSTOMER,method = RequestMethod.PUT)
     public Customer_details updatecustomer(@PathVariable("searchterm") String searchTerm,@RequestBody Customer_details customer){
                
         if(customerRep.findByCustomer_id(searchTerm).size()==0){
             throw new CustomerNotfound(searchTerm);
}

    	 
                 for(CustomerDTO customerDto : customerRep.findByCustomer_id(searchTerm)){
                	 
                	 if(customer.getName()==""){
                         throw new FieldsAreMandatoryException("Name");
         	        }
         	        if(customer.getPassword()==""){
                         throw new FieldsAreMandatoryException("Password");
         	        }
         	        if(customer.getAddress()==""){
                         throw new FieldsAreMandatoryException("Address");
         	        }

         	        if(customer.getCity()==""){
                         throw new FieldsAreMandatoryException("City");
         	        }
         	        if(customer.getState()==""){
                         throw new FieldsAreMandatoryException("State");
         	        }
         	        if(customer.getCountry()==""){
                         throw new FieldsAreMandatoryException("Country");
         	        }
         	        if(customer.getPincode()==""){
                         throw new FieldsAreMandatoryException("Pincode");
         	        }
         	        if(customer.getEmail_address()==""){
                         throw new FieldsAreMandatoryException("Email Address");
         	        }
         	        
         	        if(customer.getGender()==""){
                         throw new FieldsAreMandatoryException("Gender");
         	        }
         	        if(customer.getContact_no()==""){
                         throw new FieldsAreMandatoryException("Contact Number");
         	        }
         	        
         	        if(customer.getDateofbirth()==null){
                         throw new FieldsAreMandatoryException("Age");
         	        }
         	        if(customer.getCustomer_id()==""){
                         throw new FieldsAreMandatoryException("Customer Id");
         	        }
                 if(!customer.getName().matches("[a-zA-Z]{1,}")){
                         throw new InvalidDetailsExceptions("Name");
         	        }
         	        
                 if(!(customer.getPassword().matches(".*[0-9]{1,}.*") && customer.getPassword().matches(".*[A-Z]{1,}.*") && customer.getPassword().matches(".*[a-z]{1,}.*"))){
                     throw new InvalidDetailsExceptions("Password");
                 }
                 if(!(customer.getPincode().length()==6 && customer.getPincode().matches("[0-9]{6}"))){
                     throw new InvalidDetailsExceptions("Pincode");
                 }
                 if(!(customer.getContact_no().length()==10 && customer.getContact_no().matches("[0-9]{10}"))){
                     throw new InvalidDetailsExceptions("Contact Number");
                 }
                 
                 /*if((customer.getAddress().matches(".*[0-9]{1,}.*") && customer.getAddress().matches(".*[A-Z]{1,}.*") && customer.getAddress().matches(".*[a-z]{1,}.*"))){
                     throw new InvalidDetailsException("Address");
                 }*/
         	        
         	        
         	      
         	        if(!(customer.getAddress().matches(".*[a-zA-Z0-9' '].*") )){
                         throw new InvalidDetailsExceptions("Address");
         	        }
         	        
         	        if(!customer.getEmail_address().matches("[a-zA-z0-9'.''_']{1,}@[a-zA-z]{1,}.com")){
                         throw new InvalidDetailsExceptions("email address");
                         
         	        }
         	        long time1=customer.getDateofbirth().getTime();
         	        SimpleDateFormat sdf = new SimpleDateFormat();
         	        Date curr_date = new Date();
         	        long now = curr_date.getTime();
         	        long diff=now-time1;
         	        long l1=(24 * 60 * 60 * 1000);
         	        long l=l1*365;
         	        long age=diff/l;
         	        if(age>90)
         	        	 throw new InvalidDetailsExceptions("age");
         	        
         	        
                	 
                	 customerDto.setCustomer_id(customer.getCustomer_id());
         	        customerDto.setName(customer.getName());
         	        customerDto.setPassword(customer.getPassword());
         	        customerDto.setAddress(customer.getAddress());
         	        customerDto.setCity(customer.getCity());
         	        customerDto.setState(customer.getState());
         	        customerDto.setCountry(customer.getCountry());
         	        customerDto.setPincode(customer.getPincode());
         	        customerDto.setEmail_address(customer.getEmail_address());
         			customerDto.setGender(customer.getGender());
         			customerDto.setContact_no(customer.getContact_no());
         			customerDto.setDateofbirth(customer.getDateofbirth());
        
         customerRep.save(customerDto);
                 }
         
         return customer;
 }
     
    
     
  /*   @ApiOperation(value = "Login by Customer.", response = Customer_details.class)
     @RequestMapping(value = CustomerRestURIs.LOGIN_CUSTOMER,method = RequestMethod.POST)
     public Customer_details logincustomer(@PathVariable("searchterm") String searchTerm,@RequestBody Customer_details customer){
                
         if(customerRep.findByName(searchTerm).size()==0){
             throw new CustomerNotfound(searchTerm);
}
         for(CustomerDTO customerDto : customerRep.findByCustomer_id(searchTerm)){
        	 
        	 if(customer.getName()==""){
                 throw new FieldsAreMandatoryException("Name");
 	        
        	 }
         }
		return customer;
     }
	*/
//	 @ApiOperation(value = "Delete an existing customer.")
//		@RequestMapping(value = CustomerRestURIs.DELETE_CUSTOMER, method = RequestMethod.PUT)
//		public ResponseEntity deleteCustomer_details(@PathVariable("customer_id") String customer_id) {
//			logger.info("Start deleteCustomer.");
//			validateCustomer(customer_id);
//			
//			customerData.remove(customer_id);
//			
//			return new ResponseEntity("Product updated successfully", HttpStatus.OK);
//		}
	
	
	
	
	public void validateCustomer(String searchTerm) {
		if (customerData.get(searchTerm) == null) throw new CustomerNotfound(searchTerm);
	}
}