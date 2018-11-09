package com.vims.rs.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.vims.rs.dao.DircetPayRepository;
import com.vims.rs.dao.DirectPayDTO;
import com.vims.rs.model.DirectPay;
@Service
public class DirectPayServiceImpl implements DirectPayService {
	@Autowired
    DataSource dataSource;
	
	@Autowired
	DircetPayRepository directRep;
	
	public List<DirectPay> findBypolicyId(@Param("searchTerm") String searchTerm){
		List<DirectPay> list = new ArrayList<DirectPay>();
		for(DirectPayDTO directPayDto : directRep.findBypolicyId(searchTerm))  {
			DirectPay e=new DirectPay();
			e.setPolicyId(directPayDto.getPolicyId()); 
            e.setPremiumAmount(directPayDto.getPremiumAmount()); 
            e.setDueDate(directPayDto.getDueDate()); 
            e.setPaymentDate(directPayDto.getDueDate()); 
            e.setPaymentMode(directPayDto.getPaymentMode()); 
            e.setAmountPaid(directPayDto.getAmountPaid()); 
            e.setPaymentId(directPayDto.getPaymentId());
			list.add(e);
		
		}
		return list;
	}
	 public List<DirectPay> getAllPaymentDetails(){
		 List<DirectPay> lst = new ArrayList<DirectPay>();
			
			for (DirectPayDTO directPayDto : directRep.getAllPaymentDetails()) {
	            DirectPay e = new DirectPay();
	            e.setPolicyId(directPayDto.getPolicyId()); 
	            e.setPremiumAmount(directPayDto.getPremiumAmount()); 
	            e.setDueDate(directPayDto.getDueDate()); 
	            e.setPaymentDate(directPayDto.getDueDate()); 
	            e.setPaymentMode(directPayDto.getPaymentMode()); 
	            e.setAmountPaid(directPayDto.getAmountPaid()); 
	            e.setPaymentId(directPayDto.getPaymentId());
	            
	            lst.add(e);
	        }
	                
	        return lst;
	 }

}
