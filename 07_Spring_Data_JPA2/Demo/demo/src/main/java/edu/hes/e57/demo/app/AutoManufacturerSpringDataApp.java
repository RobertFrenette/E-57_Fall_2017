package edu.hes.e57.demo.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import edu.hes.e57.demo.domain.Auto;
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
		
		// Find all Autos in the DB
		List<Auto> autos = autoService.findAll();
		listAllAutos(autos);
		
		autos = autoService.findByModel("Camaro");
		listAllAutos(autos);
		
		// Close 
		ctx.close();
	}
	
	/**
	 * This method loops through a List of Auto Objects and displays each Auto.
	 * 
	 * @param autos - List of Auto Objects (all Autos in the DB)
	 */
	private static void listAllAutos(List<Auto> autos) {
		// Loop through Autos
		LOGGER.info("\n\nStart listAllAutos()");
		for (Auto auto : autos) {
			LOGGER.info(auto.toString());
		}
		LOGGER.info("End listAllAutos()\n");
	}
}
