package edu.hes.e57.demo.service;

import java.util.List;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Drivetrain;
import edu.hes.e57.demo.domain.Manufacturer;

public interface AutoManufacturerService {
	List<Auto> findByCriteriaQuery(String model);
}
