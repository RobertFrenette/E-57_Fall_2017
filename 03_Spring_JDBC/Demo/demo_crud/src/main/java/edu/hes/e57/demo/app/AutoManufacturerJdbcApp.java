package edu.hes.e57.demo.app;

import java.util.List;
import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.hes.e57.demo.dao.AutoManufacturerDao;
import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Manufacturer;

/**
 * mvn clean install
 * mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerJdbcApp" -Dexec.cleanupDaemonThreads=false
 * mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerJdbcApp" -Dexec.cleanupDaemonThreads=false
 */
public class AutoManufacturerJdbcApp {
	private static final Logger LOGGER = LoggerFactory.getLogger(AutoManufacturerJdbcApp.class);
	
	public static void main(String[] args) {
		// Load Spring Bean
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
		ctx.refresh();
		
		// Create DAO Object
		AutoManufacturerDao autoManufacturerDao = ctx.getBean("autoManufacturerDao", AutoManufacturerDao.class);
		
		// Get all Manufacturers from DB, store as List of Manufacturer Objects
		List<Manufacturer> manufacturers = autoManufacturerDao.findAllManufacturers();
		
		// Insert a new Auto into the DB
		insertNewAuto(manufacturers, autoManufacturerDao);

		// Update an existing Auto in the DB
		updateExistingAuto(autoManufacturerDao);

		// Delete an existing Auto from the DB
		deleteExistingAuto(autoManufacturerDao);

		// Close 
		ctx.close();
	}

	/**
	 * This utility method loops through a List of Auto Objects
	 * and displays each Auto.  
	 * 
	 * @param autos - List of Auto Objects
	 */
	private static void listAllAutos(List<Auto> autos) {
		for (Auto auto : autos) {
			LOGGER.info(auto.toString());
		}
	}
		
	/**
	 * This method inserts a new Auto into the DB. 
	 * 
	 * @param manufacturers - List of all Manufacturers in DB
	 * @param autoManufacturerDao - DAO
	 */
	private static void insertNewAuto(List<Manufacturer> manufacturers, AutoManufacturerDao autoManufacturerDao) {
		// CONST used to get a specific Manufacturer from the List of Manufacturers
		final int MANUFACTURER_INDEX = 0;
		// Get a Manufacturer
		Manufacturer manufacturer = manufacturers.get(MANUFACTURER_INDEX);

		Long manufacturerId = manufacturer.getId();
		String manufacturerName = manufacturer.getName();
		String model = "Chevelle";
		String year  = "1970";
		String msrp  = "20,000";

		LOGGER.info("Printing All Autos for Manufacturer '" + manufacturerName + "' BEFORE Insert:");
		// Get all Autos from DB, for a specific manufacturerName, then display them before the INSERT is executed
		List<Auto> manufacturerAutos = autoManufacturerDao.findAllAutosByManufacturerId(manufacturerId);
		listAllAutos(manufacturerAutos);

		// Create new Auto
		Auto auto = new Auto();
		auto.setManufacturerId(manufacturerId);
		auto.setModel(model);
		auto.setYear(year);
		auto.setMsrp(msrp);

		// Insert Auto into DB
		autoManufacturerDao.insertAuto(auto);

		LOGGER.info("Printing All Autos for Manufacturer '" + manufacturerName + "' AFTER Insert:");
		// Get all Autos from DB, for a specific manufacturerName, then display them after the INSERT is executed
		manufacturerAutos = autoManufacturerDao.findAllAutosByManufacturerId(manufacturerId);
		listAllAutos(manufacturerAutos);
	}
	
    /**
     * This method updates an existing Auto in the DB.
     * 
     * @param autoManufacturerDao - DAO
     */
    private static void updateExistingAuto(AutoManufacturerDao autoManufacturerDao) {
        final String MODEL = "Chevelle";
        final String NEW_MSRP = "30,000";

        // Get specific Auto from DB by Model
        List<Auto> autos = autoManufacturerDao.findAutoByModel(MODEL);
        Auto auto = autos.get(0);
        // Get current Auto Id for later use
        Long autoId = auto.getId();

        LOGGER.info("Printing Auto Model '" + auto.getModel() + "' BEFORE Update:");
        LOGGER.info(auto.toString());
        auto.setMsrp(NEW_MSRP);

        // Update Auto in DB
        autoManufacturerDao.updateAuto(auto);

        // Get specific Auto from DB by Id
        autos = autoManufacturerDao.findAutoById(autoId);
        auto = autos.get(0);

        LOGGER.info("Printing Auto Model '" + auto.getModel() + "' AFTER Update:");
        LOGGER.info(auto.toString());
    }
    
    /**
     * This method deletes an existing Auto from the DB. 
     * 
     * @param autoManufacturerDao - DAO
     */
    private static void deleteExistingAuto(AutoManufacturerDao autoManufacturerDao) {
        String manufacturerName = "Chevrolet";

        LOGGER.info("Printing All '" + manufacturerName + "' Autos BEFORE Delete:");
        // Get all Autos for a specific Manufacturer by Manufacturer Name
        List<Auto> manufacturerAutos = autoManufacturerDao.findAllAutosByManufacturerName(manufacturerName);
		listAllAutos(manufacturerAutos);

        String model = "Chevelle";
        List<Auto> autos = autoManufacturerDao.findAutoByModel(model);
        Auto auto = autos.get(0);
        Long autoId = auto.getId();

        // Delete Auto from DB
        autoManufacturerDao.deleteAuto(autoId);

        LOGGER.info("Printing All '" + manufacturerName + "' Autos AFTER Delete:");
        manufacturerAutos = autoManufacturerDao.findAllAutosByManufacturerName(manufacturerName);
		listAllAutos(manufacturerAutos);
    }
}
