package com.vims.rs.service;

import java.util.List;

import com.vims.rs.dao.VehicleDTO;
import com.vims.rs.model.Vehicle_details;

public interface VehicleService {

	public List<Vehicle_details> getAllVehicles();
	public List<Vehicle_details> getVehicleBySearchTerm(String searchTerm);
	
	
	
	
}
