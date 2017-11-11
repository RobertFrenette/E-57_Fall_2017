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
		
        List<Auto> autos = autoManufacturerService.findByCriteriaQuery("Camaro");
        listAutos(autos);
		
		// Close 
		ctx.close();
	}

	/**
	 * This method loops through a List of Auto Objects and displays each Auto.
	 * 
	 * @param autos - List of Auto Objects (all Autos in the DB)
	 */
	private static void listAutos(List<Auto> autos) {
		// Loop through Autos
		LOGGER.info("Start listAllAutos()");
		for (Auto auto : autos) {
			LOGGER.info(auto.toString());
		}
		LOGGER.info("End listAllAutos()\n\n");
	}
}
