package edu.hes.e57.demo.app;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import edu.hes.e57.demo.dao.AutoManufacturerDao;
import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Drivetrain;
import edu.hes.e57.demo.domain.Manufacturer;

/**
 * mvn clean install 
 * mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerHibernateApp" -Dexec.cleanupDaemonThreads=false 
 * mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerHibernateApp" -Dexec.cleanupDaemonThreads=false
 */
public class AutoManufacturerHibernateApp {
	private static final Logger LOGGER = LoggerFactory.getLogger(AutoManufacturerHibernateApp.class);

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
		ctx.refresh();

		AutoManufacturerDao autoManufacturerDao = ctx.getBean("autoManufacturerDao", AutoManufacturerDao.class);

		// Find all Autos in the DB (with Drivetrains and Manufacturers)
		List<Auto> autos = autoManufacturerDao.findAllAutosWithDrivetrainsAndManufacturers();
		listAllAutosWithDrivetrainsAndManufacturers(autos);

		// Find a specific Auto in the DB (with Drivetrains and Manufacturer by Auto Id)
		Long autoId = 1L; // Auto Id 1
		Auto auto = autoManufacturerDao.findAutoWithDrivetrainsAndManufacturerByAutoId(autoId);
		listAuto(auto, autoId);

		// Create / Add new Auto with new Manufacturer and Drivetrains
        LOGGER.info("List all Autos BEFORE Insert...");
		autos = autoManufacturerDao.findAllAutos();
		listAllAutos(autos);
				
		// Create new Manufacturer
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setName("BMW");
		
		// Add / Save a new Auto, with new Drivetrains, for new Manufacturer in the DB
        Auto newAuto = new Auto();
        newAuto.setModel("3 Series");
        newAuto.setYear("2017");
        newAuto.setMsrp("33,450");

		// Create new Drivetrains
		Set<Drivetrain> drivetrains = new HashSet<Drivetrain>();
		
		Drivetrain drivetrainAuto = new Drivetrain();
		drivetrainAuto.setTransmission("Automatic");
		drivetrainAuto.setEngineDisplacement("3.0");
		drivetrains.add(drivetrainAuto);
		
		Drivetrain drivetrainManual = new Drivetrain();
		drivetrainManual.setTransmission("Manual");
		drivetrainManual.setEngineDisplacement("3.0");
		drivetrains.add(drivetrainManual);
		
		// Add Drivetrains to Auto
		newAuto.setDrivetrains(drivetrains);
		// Add the new Manufacturer to the new Auto
		newAuto.setManufacturer(manufacturer);
		// Add the new Auto to the new Manufacturer 
		manufacturer.addAuto(newAuto);
		
		// Save the new Manufacturer (with Auto, with Drivetrains) to the DB
		autoManufacturerDao.save(manufacturer);
        
        autos = autoManufacturerDao.findAllAutosWithDrivetrainsAndManufacturers();
        LOGGER.info("List all Autos AFTER Insert...");
		listAllAutosWithDrivetrainsAndManufacturers(autos);
        
        // Delete Auto from DB
        autoManufacturerDao.delete(newAuto);

        autos = autoManufacturerDao.findAllAutos();
        LOGGER.info("List all Autos AFTER Delete...");
        listAllAutos(autos);
		
		// Close
		ctx.close();
	}
	
	/**
	 * This method displays a specific Auto, with Drivetrains and Manufacturer,
	 * by Auto Id.
	 * 
	 * @param auto - Auto Object to be displayed
	 * @param autoId - Auto Id
	 */
	private static void listAuto(Auto auto, Long autoId) {
		LOGGER.info("Start listAuto() for Auto ID: " + autoId);
		if (auto != null) {
			LOGGER.info(auto.toString());
			if (auto.getManufacturer() != null) {
				LOGGER.info(auto.getManufacturer().toString());
			}
			if (auto.getDrivetrains() != null) {
				for (Drivetrain drivetrain : auto.getDrivetrains()) {
					LOGGER.info(drivetrain.toString());
				}
			}
		}
		LOGGER.info("End listAuto() for Auto ID: " + autoId + "\n\n");
	}

	/**
	 * This method loops through a List of Auto Objects and displays each Auto.
	 * 
	 * @param autos - List of Auto Objects (all Autos in the DB)
	 */
	private static void listAllAutos(List<Auto> autos) {
		// Loop through Autos
		LOGGER.info("Start listAllAutos()");
		for (Auto auto : autos) {
			LOGGER.info(auto.toString());
		}
		LOGGER.info("End listAllAutos()\n\n");
	}

	/**
	 * This method loops through a List of Autos Objects and displays each Auto
	 * with it's Drivetrain and Manufacturer.
	 * 
	 * @param autos - List of autos Objects (all Autos in the DB with Drivetrain and Manufacturer)
	 */
	private static void listAllAutosWithDrivetrainsAndManufacturers(List<Auto> autos) {
		LOGGER.info("Start listAllAutosWithDrivetrainsAndManufacturers()");
		for (Auto auto : autos) {
			LOGGER.info(auto.toString());

			if (auto.getManufacturer() != null) {
				LOGGER.info(auto.getManufacturer().toString());
			}
			if (auto.getDrivetrains() != null) {
				for (Drivetrain drivetrain : auto.getDrivetrains()) {
					LOGGER.info(drivetrain.toString());
				}
			}
			LOGGER.info("");
		}
		LOGGER.info("End listAllAutosWithDrivetrainsAndManufacturers()\n\n");
	}
}
