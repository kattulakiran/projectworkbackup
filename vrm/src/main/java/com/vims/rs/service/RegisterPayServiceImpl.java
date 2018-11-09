package com.vims.rs.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vims.rs.dao.RegisterPayDTO;
import com.vims.rs.dao.RegisterPayRepository;
import com.vims.rs.model.Register_pay;

@Service
public class RegisterPayServiceImpl implements RegisterPayService{
	
	@Autowired
	 DataSource dataSource;
	@Autowired
	RegisterPayRepository regPay;

	public List<Register_pay> getAllVehicles() {
		
		List<Register_pay> list = new ArrayList<Register_pay>();
		
		for(RegisterPayDTO payDto : regPay.getAllVehicles()) {
			Register_pay vd=new Register_pay();
			vd.setPolicy_id(payDto.getPolicy_id());
			vd.setPremium_amount(payDto.getPremium_amount());
			vd.setDue_date(payDto.getDue_date());
			vd.setCurrent_date(payDto.getCurrent_date());
			vd.setPayment_mode(payDto.getPayment_mode());
			vd.setAmount_paid(payDto.getAmount_paid());
			vd.setPayment_id(payDto.getPayment_id());
			list.add(vd);
			
		}
		return list;
	}
		
		
	

	public List<Register_pay> getVehicleBySearchTerm(String searchTerm) {
		
		List<Register_pay> list = new ArrayList<Register_pay>();
		
		for(RegisterPayDTO payDto : regPay.findByPolicy_id(searchTerm)) {
			Register_pay vd=new Register_pay();
			vd.setPolicy_id(payDto.getPolicy_id());
			vd.setPremium_amount(payDto.getPremium_amount());
			vd.setDue_date(payDto.getDue_date());
			vd.setCurrent_date(payDto.getCurrent_date());
			vd.setPayment_mode(payDto.getPayment_mode());
			vd.setAmount_paid(payDto.getAmount_paid());
			vd.setPayment_id(payDto.getPayment_id());
			list.add(vd);
			
		}
		return list;
	}		
}
		
	


