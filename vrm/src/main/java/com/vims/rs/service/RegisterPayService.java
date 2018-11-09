package com.vims.rs.service;

import java.util.List;

import com.vims.rs.model.Register_pay;

public interface RegisterPayService {

	
		public List<Register_pay> getAllVehicles();
		public List<Register_pay> getVehicleBySearchTerm(String searchTerm);
	}


