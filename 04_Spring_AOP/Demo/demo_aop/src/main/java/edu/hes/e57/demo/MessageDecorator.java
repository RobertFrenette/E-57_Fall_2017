package edu.hes.e57.demo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MessageDecorator class is the around-advice implementation.
 */
public class MessageDecorator implements MethodInterceptor {
	private static Logger logger = LoggerFactory.getLogger(MessageDecorator.class);

	public Object invoke(MethodInvocation invocation) throws Throwable {
		logger.info("Hello ");
		Object retVal = invocation.proceed();
		logger.info("!");

		return retVal;
	}
}
