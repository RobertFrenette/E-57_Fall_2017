package edu.hes.e57.demo.app;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Drivetrain;
import edu.hes.e57.demo.domain.Manufacturer;
import edu.hes.e57.demo.service.AutoService;

/**
 * mvn clean install
 * mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerSpringDataApp" -Dexec.cleanupDaemonThreads=false
 * mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerSpringDataApp" -Dexec.cleanupDaemonThreads=false
 */
public class AutoManufacturerSpringDataApp {
	private static final Logger LOGGER = LoggerFactory.getLogger(AutoManufacturerSpringDataApp.class);
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
		ctx.refresh();

		AutoService autoService = ctx.getBean("springDataAutoService", AutoService.class);
		
		// Create / Add new Auto with new Manufacturer and Drivetrains
        LOGGER.info("List all Autos BEFORE Insert...");
		List<Auto> autos = autoService.findAll();
		listAllAutosWithAndManufacturers(autos);
				
		// Create Manufacturer (Use 1st Manufacturer in DB - Chevrolet)
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setId(1L);
		
		// Add / Save a new Auto, with new Drivetrains, for new Manufacturer in the DB
        Auto newAuto = new Auto();
        newAuto.setManufacturer(manufacturer);
        newAuto.setModel("Chevelle");
        newAuto.setYear("1970");
        newAuto.setMsrp("15,000");

		// Create new Drivetrains
		Set<Drivetrain> drivetrains = new HashSet<Drivetrain>();
		
		Drivetrain drivetrainAuto = new Drivetrain();
		drivetrainAuto.setTransmission("Automatic");
		drivetrainAuto.setEngineDisplacement("454");
		drivetrains.add(drivetrainAuto);
		
		Drivetrain drivetrainManual = new Drivetrain();
		drivetrainManual.setTransmission("Manual");
		drivetrainManual.setEngineDisplacement("454");
		drivetrains.add(drivetrainManual);
		
		// Add Drivetrains to Auto
		newAuto.setDrivetrains(drivetrains);
		// Add the new Manufacturer to the new Auto
		newAuto.setManufacturer(manufacturer);
		// Add the new Auto to the new Manufacturer 
		manufacturer.addAuto(newAuto);
		
		// Save the new Auto
		Auto savedAuto = autoService.save(newAuto);
		
		// Close
		ctx.close();
	}

	/**
	 * This method loops through a List of Autos Objects and displays each Auto
	 * with it's Manufacturer.
	 * 
	 * @param autos - List of autos Objects (all Autos in the DB with  Manufacturer)
	 */
	private static void listAllAutosWithAndManufacturers(List<Auto> autos) {
		LOGGER.info("Start listAllAutosWithAndManufacturers()");
		for (Auto auto : autos) {
			LOGGER.info(auto.toString());

			if (auto.getManufacturer() != null) {
				LOGGER.info(auto.getManufacturer().toString());
			}
			LOGGER.info("");
		}
		LOGGER.info("End listAllAutosWithAndManufacturers()\n\n");
	}
}
