package edu.hes.e57.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.ProxyFactory;

/**
 * This example is taken from Pro Spring 4: com.apress.prospring4.ch5
 * 
 * mvn clean install
 * mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.HelloWorldAOPExample" -Dexec.cleanupDaemonThreads=false
 * mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.HelloWorldAOPExample" -Dexec.cleanupDaemonThreads=false
 */
public class HelloWorldAOPExample {
	private static Logger logger = LoggerFactory.getLogger(HelloWorldAOPExample.class);

	public static void main(String[] args) {

		MessageWriter target = new MessageWriter();

		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new MessageDecorator());
		pf.setTarget(target);

		MessageWriter proxy = (MessageWriter) pf.getProxy();

		target.writeMessage();
		logger.info("");

		proxy.writeMessage();
	}
}
