package edu.hes.e57.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * mvn clean install
 * mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.App2" -Dexec.cleanupDaemonThreads=false
 * mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.App2" -Dexec.cleanupDaemonThreads=false
 */

@Configuration
@ComponentScan(basePackages = {"edu.hes.e57.demo"})
public class App2 {
	public static void main(String[] args) {
		// Load Spring Bean
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(App2.class);
		ctx.refresh();
		
		MessageRenderer messageRenderer = ctx.getBean("messageRenderer", MessageRenderer.class);
		messageRenderer.render();
		   
		ctx.close();
	}
}
