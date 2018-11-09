package com.vims.rs.service;

import java.util.List;

import com.vims.rs.model.Cancellation;



public interface CancellationService {

	public List<Cancellation> getAllVehicles();
	public List<Cancellation> getVehicleBySearchTerm(String searchTerm);
	
	
}
