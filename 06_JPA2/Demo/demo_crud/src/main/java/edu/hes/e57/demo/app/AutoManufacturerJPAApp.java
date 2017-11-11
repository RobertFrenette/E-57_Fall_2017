package edu.hes.e57.demo.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Drivetrain;
import edu.hes.e57.demo.domain.Manufacturer;
import edu.hes.e57.demo.service.AutoManufacturerService;

/**
 * mvn clean install
 * mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerJPAApp" -Dexec.cleanupDaemonThreads=false
 * mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerJPAApp" -Dexec.cleanupDaemonThreads=false
 */
public class AutoManufacturerJPAApp {
	private static final Logger LOGGER = LoggerFactory.getLogger(AutoManufacturerJPAApp.class);
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
		ctx.refresh();

		AutoManufacturerService autoManufacturerService = ctx.getBean("jpaAutoService", AutoManufacturerService.class);
		
		// Find a specific Auto in the DB (with Drivetrains and Manufacturer by Auto Id)
		Long autoId = 1L; // Auto Id 1
		Auto auto = autoManufacturerService.findAutoWithDrivetrainsAndManufacturerByAutoId(autoId);
		listAuto(auto, autoId);
		
		// Create / Add new Auto with new Manufacturer and Drivetrains
        LOGGER.info("List all Autos BEFORE Insert...");
		List<Auto> autos = autoManufacturerService.findAllAutos();
		listAllAutos(autos);
			
		// Create new Auto
        Auto newAuto = new Auto();
        newAuto.setModel("Corvette");
        newAuto.setYear("2017");
        newAuto.setMsrp("65,495");
        // Use existing Manufacturer
        newAuto.setManufacturer(new Manufacturer(1L));
        // Use existing Drivetrain
        newAuto.addDrivetrain(new Drivetrain(6L));

        // Save Auto to DB
		autoManufacturerService.save(newAuto);
        
        autos = autoManufacturerService.findAllAutos();
        LOGGER.info("List all Autos AFTER Insert...");
        listAllAutos(autos);
        
		auto = autoManufacturerService.findAutoWithDrivetrainsAndManufacturerByAutoId(7L);
		listAuto(auto, 7L);
        
        // Delete Auto from DB
		autoManufacturerService.delete(newAuto);

        autos = autoManufacturerService.findAllAutos();
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
}
