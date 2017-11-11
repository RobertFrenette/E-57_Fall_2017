package edu.hes.e57.demo.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Drivetrain;
import edu.hes.e57.demo.domain.Manufacturer;
import edu.hes.e57.demo.service.AutoService;

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

		AutoService autoService = ctx.getBean("jpaAutoService", AutoService.class);
		
		// Find all Manufacturers in the DB
		List<Manufacturer> manufacturers = autoService.findAllManufacturers();
		listAllManufacturers(manufacturers);

		// Find all Drivetrains in the DB
		List<Drivetrain> drivetrains = autoService.findAllDrivetrainsByNativeSimpleQuery();
		listAllDrivetrains(drivetrains);
		
		// Find all Autos in the DB
		List<Auto> autos = autoService.findAllAutosByNativeResultSetMapping();
		listAllAutos(autos);
		
		// Close 
	
		ctx.close();
	}
	
	/**
	 * This method loops through a List of Manufacturer Objects
	 * and displays each Manufacturer. 
	 * 
	 * @param manufacturers - List of Manufacturer Objects (All Manufacturers in the DB)
	 */
	private static void listAllManufacturers(List<Manufacturer> manufacturers) {
		// Loop through Manufacturers
		LOGGER.info("\n\nStart listAllManufacturers()");
		for (Manufacturer manufacturer : manufacturers) {
			LOGGER.info(manufacturer.toString());
		}
		LOGGER.info("End listAllManufacturers()\n");
	}

	/**
	 * This method loops through a List of Drivetrain Objects and displays each
	 * Drivetrain.
	 * 
	 * @param drivetrains - List of drivetrains Objects (all Drivetrains in the DB)
	 */
	private static void listAllDrivetrains(List<Drivetrain> drivetrains) {
		// Loop through Drivetrains
		LOGGER.info("Start listAllDrivetrains()");
		for (Drivetrain drivetrain : drivetrains) {
			LOGGER.info(drivetrain.toString());
		}
		LOGGER.info("End listAllDrivetrains()\n");
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
		LOGGER.info("End listAllAutos()\n");
	}
}
