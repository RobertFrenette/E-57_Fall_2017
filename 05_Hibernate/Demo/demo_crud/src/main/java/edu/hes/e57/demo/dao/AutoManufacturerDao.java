package edu.hes.e57.demo.dao;

import java.util.List;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Drivetrain;
import edu.hes.e57.demo.domain.Manufacturer;

public interface AutoManufacturerDao {
    // Find all Autos in the DB
    List<Auto> findAllAutos();
    
	// Find all Autos in the DB (with Drivetrains and Manufacturers)
	List<Auto> findAllAutosWithDrivetrainsAndManufacturers();
	
	// Find a specific Auto in the DB (with Drivetrains and Manufacturer by Auto Id)
	Auto findAutoWithDrivetrainsAndManufacturerByAutoId(Long id);

	// Save a new Manufacturer to the DB
	Manufacturer save(Manufacturer manufacturer);
	
	// Delete an Auto from the DB
	void delete(Auto auto);
}
