package edu.hes.e57.demo;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This example is taken from Pro Spring 4: com.apress.prospring4.ch5
 * 
 * mvn clean install
 * mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.SimpleThrowsAdvice" -Dexec.cleanupDaemonThreads=false
 * mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.SimpleThrowsAdvice" -Dexec.cleanupDaemonThreads=false
 */
public class SimpleThrowsAdvice implements ThrowsAdvice {
	private static Logger logger = LoggerFactory.getLogger(SimpleThrowsAdvice.class);

	public static void main(String[] args) throws Exception {
		ErrorBean errorBean = new ErrorBean();

		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(errorBean);
		pf.addAdvice(new SimpleThrowsAdvice());

		ErrorBean proxy = (ErrorBean) pf.getProxy();

		try {
			proxy.errorProneMethod();
		} catch (Exception ignored) {

		}

		try {
			proxy.otherErrorProneMethod();
		} catch (Exception ignored) {

		}
	}

	public void afterThrowing(Exception ex) throws Throwable {
		logger.info("***");
		logger.info("Generic Exception Capture");
		logger.info("Caught: " + ex.getClass().getName());
		logger.info("***\n");
	}

	public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException ex)
			throws Throwable {
		logger.info("***");
		logger.info("IllegalArgumentException Capture");
		logger.info("Caught: " + ex.getClass().getName());
		logger.info("Method: " + method.getName());
		logger.info("***\n");
	}
}
