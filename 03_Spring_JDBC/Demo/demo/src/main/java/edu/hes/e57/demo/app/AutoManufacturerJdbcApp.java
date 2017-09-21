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
		
		// Get all Manufacturers from DB, store as List of Manufacturer Objects, then display them.
		List<Manufacturer> manufacturers = autoManufacturerDao.findAllManufacturers();
		listAllManufacturers(manufacturers);
		
		// Get all Autos from DB, store as List of Auto Objects, then display them.
		List<Auto> autos = autoManufacturerDao.findAllAutos();
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
		for (Manufacturer manufacturer : manufacturers) {
			LOGGER.info(manufacturer.toString());
		}
	}

	/**
	 * This method loops through a List of Auto Objects
	 * and displays each Auto.  
	 * 
	 * @param autos - List of Auto Objects (all Autos in the DB)
	 */
	private static void listAllAutos(List<Auto> autos) {
		for (Auto auto : autos) {
			LOGGER.info(auto.toString());
		}
	}
}
