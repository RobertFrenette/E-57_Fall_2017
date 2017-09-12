package edu.hes.e57.demo;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * mvn clean install
 * mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.App" -Dexec.cleanupDaemonThreads=false
 * mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.App" -Dexec.cleanupDaemonThreads=false
 */
public class App {
	public static void main(String[] args) {
		// Load Spring Bean
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
		ctx.refresh();
		
		MessageRenderer messageRenderer = ctx.getBean("messageRenderer", MessageRenderer.class);
		messageRenderer.render();
		   
		ctx.close();
	}
}
