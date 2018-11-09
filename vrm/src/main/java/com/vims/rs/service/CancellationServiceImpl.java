package com.vims.rs.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vims.rs.dao.CancellationDTO;
import com.vims.rs.dao.CancellationRepository;
import com.vims.rs.model.Cancellation;

@Service
public class CancellationServiceImpl implements CancellationService{
	
	
	@Autowired
	 DataSource dataSource;
	@Autowired
	CancellationRepository canrep;

	public List<Cancellation> getAllVehicles() {
		
		List<Cancellation> list = new ArrayList<Cancellation>();
		for(CancellationDTO canDto : canrep.getAllVehicles()) {
			Cancellation vd=new Cancellation();
			vd.setCancel_id(canDto.getCancel_id());
			vd.setCustomer_id(canDto.getCustomer_id());
			vd.setPolicy_id(canDto.getPolicy_id());
			vd.setTotal_amt(canDto.getTotal_amt());
			vd.setRegistration_date(canDto.getRegistration_date());
			vd.setLast_paid_date(canDto.getLast_paid_date());
			vd.setCancelled_date(canDto.getCancelled_date());
			vd.setWithdraw_amt(canDto.getWithdraw_amt());
            list.add(vd);
			
		}
		return list;
		
	}

	public List<Cancellation> getVehicleBySearchTerm(String searchTerm) {
		List<Cancellation> list = new ArrayList<Cancellation>();
		for(CancellationDTO canDto : canrep.getAllVehicles()) {
			Cancellation vd=new Cancellation();
			vd.setCancel_id(canDto.getCancel_id());
			vd.setCustomer_id(canDto.getCustomer_id());
			vd.setPolicy_id(canDto.getPolicy_id());
			vd.setTotal_amt(canDto.getTotal_amt());
			vd.setRegistration_date(canDto.getRegistration_date());
			vd.setLast_paid_date(canDto.getLast_paid_date());
			vd.setCancelled_date(canDto.getCancelled_date());
			vd.setWithdraw_amt(canDto.getWithdraw_amt());
            list.add(vd);
			
		}
		return list;
		}
		
	}
	


