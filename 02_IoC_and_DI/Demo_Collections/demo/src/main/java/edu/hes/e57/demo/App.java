package edu.hes.e57.demo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.Resource;

/**
 * mvn clean install
 * mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.App" -Dexec.cleanupDaemonThreads=false
 * mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.App" -Dexec.cleanupDaemonThreads=false
 */

@Service("injectCollection")
public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
    @Resource(name="map")
    private Map<String, Object> map;

    @Resource(name="props")
    private Properties props;

    @Resource(name="set")
    private Set set;
    
    @Resource(name="list")
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context.xml");
        ctx.refresh();  

        App instance = (App) ctx.getBean("injectCollection");
        instance.displayInfo();
        ctx.close();
    }

    public void displayInfo() {
    		LOGGER.info("Map contents:");
        for (Map.Entry<String, Object> entry: map.entrySet()) {
        		LOGGER.info("Key: " + entry.getKey() + " - Value: " + entry.getValue());
        }

        LOGGER.info("\nProperties contents:");
        for (Map.Entry<Object, Object> entry: props.entrySet()) {
        	LOGGER.info("Key: " + entry.getKey() + " - Value: " + entry.getValue());
        }

        LOGGER.info("\nSet contents:");
        for (Object obj: set) {
        		LOGGER.info("Value: " + obj);
        }

        LOGGER.info("\nList contents:");
        for (Object obj: list) {
        		LOGGER.info("Value: " + obj);
        }
    }
}
