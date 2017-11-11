package edu.hes.e57.demo.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Autos;

/**
 * mvn clean install
 * mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoSpringRESTApp" -Dexec.cleanupDaemonThreads=false
 * mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoSpringRESTApp" -Dexec.cleanupDaemonThreads=false
 */
public class AutoSpringRESTApp {
	private static final Logger LOGGER = LoggerFactory.getLogger(AutoSpringRESTApp.class);
    private static final String URL_GET_ALL_AUTOS  = "http://localhost:8080/springrest/restful/auto/listdata";
    private static final String URL_GET_AUTO_BY_ID = "http://localhost:8080/springrest/restful/auto/{id}";
    private static final String URL_CREATE_AUTO = "http://localhost:8080/springrest/restful/auto/";
    private static final String URL_UPDATE_AUTO = "http://localhost:8080/springrest/restful/auto/{id}";
    private static final String URL_DELETE_AUTO = "http://localhost:8080/springrest/restful/auto/{id}";
	
	public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/restful-client-app-context.xml");
        ctx.refresh();

        Auto auto;
        RestTemplate restTemplate = ctx.getBean("restTemplate", RestTemplate.class);

        LOGGER.info("Testing retrieve all autos:");
        Autos autos = restTemplate.getForObject(URL_GET_ALL_AUTOS, Autos.class);
        listAutos(autos);

        LOGGER.info("Testing retrieve a auto by id :");
        auto = restTemplate.getForObject(URL_GET_AUTO_BY_ID, Auto.class, 1);
        LOGGER.info(auto.toString());
        LOGGER.info("");

        auto = restTemplate.getForObject(URL_UPDATE_AUTO, Auto.class, 1);
        auto.setModel("New Model");
        LOGGER.info("Testing update auto by id :");
        restTemplate.put(URL_UPDATE_AUTO, auto, 1);
        LOGGER.info("Auto updated successfully: " + auto);
        LOGGER.info("");

        restTemplate.delete(URL_DELETE_AUTO, 1);
        LOGGER.info("Testing delete auto by id :");
        autos = restTemplate.getForObject(URL_GET_ALL_AUTOS, Autos.class);
        listAutos(autos);

        LOGGER.info("Testing create auto :");
        Auto newAuto = new Auto();
        newAuto.setModel("Chevelle");
        newAuto.setYear("1970");
        newAuto.setMsrp("15,000");
        newAuto = restTemplate.postForObject(URL_CREATE_AUTO, newAuto, Auto.class);
        LOGGER.info("Auto created successfully: " + newAuto);
		
		// Close 
		ctx.close();
	}
	
    private static void listAutos(Autos autos) {
        for (Auto auto: autos.getAutos()) {
            LOGGER.info(auto.toString());
        }
        LOGGER.info("");
    }
}
