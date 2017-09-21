package edu.hes.e57.demo.dao;

import java.util.List;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Manufacturer;

public interface AutoManufacturerDao {
	// Find all Manufacturers in the DB
    List<Manufacturer> findAllManufacturers();
    
    // Find all Autos in the DB for a Manufacturer by Manufacture Id
    List<Auto> findAllAutosByManufacturerId(Long manufactureId);
    // Find all Autos in the DB for a Manufacturer by Manufacture Name
    List<Auto> findAllAutosByManufacturerName(String manufactureName);
    
    // Find a specific Auto in the DB by Auto Model
    List<Auto> findAutoByModel(String model);
    // Find a specific Auto in the DB by Auto Id
    List<Auto> findAutoById(Long id);
    
    // Insert a new Auto into the DB
    void insertAuto(Auto auto);
    // Update an existing Auto in the DB
    void updateAuto(Auto auto);
    // Delete an existing Auto from the DB
    void deleteAuto(Long id);
}
