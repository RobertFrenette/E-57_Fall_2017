package edu.hes.e57.demo.service;

import java.util.List;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Drivetrain;
import edu.hes.e57.demo.domain.Manufacturer;

public interface AutoService {
	// Find all Manufacturers in the DB
    List<Manufacturer> findAllManufacturers();
    
    // Find all Drivetrains in the DB
    List<Drivetrain> findAllDrivetrainsByNativeSimpleQuery();
    
    // Find all Autos in the DB
    List<Auto> findAllAutosByNativeResultSetMapping();
}
