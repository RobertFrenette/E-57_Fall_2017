package edu.hes.e57.demo.service;

import java.util.List;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Drivetrain;
import edu.hes.e57.demo.domain.Manufacturer;

public interface AutoManufacturerService {
    // Find all Autos in the DB (without Drivetrains and Manufacturers)
    List<Auto> findAllAutos();
    
	// Find a specific Auto in the DB (with Drivetrains and Manufacturer by Auto Id)
	Auto findAutoWithDrivetrainsAndManufacturerByAutoId(Long id);
	
	// Save a new Auto to the DB
	Auto save(Auto auto);
	
	// Delete an Auto from the DB
	void delete(Auto auto);
}
