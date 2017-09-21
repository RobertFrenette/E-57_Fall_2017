package edu.hes.e57.demo.dao;

import java.util.List;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Manufacturer;

public interface AutoManufacturerDao {
	// Find all Manufacturers in the DB
    List<Manufacturer> findAllManufacturers();
	// Find all Autos in the DB
    List<Auto> findAllAutos();
}
