package edu.hes.e57.demo.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.service.AutoService;

/**
 * mvn clean install
 * mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerSpringTrxApp" -Dexec.cleanupDaemonThreads=false
 * mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerSpringTrxApp" -Dexec.cleanupDaemonThreads=false
 */
public class AutoManufacturerSpringTrxApp {
	private static final Logger LOGGER = LoggerFactory.getLogger(AutoManufacturerSpringTrxApp.class);
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
		ctx.refresh();

		AutoService autoService = ctx.getBean("autoService", AutoService.class);
		
		// Find all Autos in the DB
		List<Auto> autos = autoService.findAll();
		listAllAutos(autos);
				
		LOGGER.info("Auto count: " + autoService.countAll());
		
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
