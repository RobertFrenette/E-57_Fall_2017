package edu.hes.e57.demo;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfilingInterceptor implements MethodInterceptor {
	private static Logger logger = LoggerFactory.getLogger(ProfilingInterceptor.class);

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(invocation.getMethod().getName());

		Object returnValue = invocation.proceed();
		sw.stop();

		dumpInfo(invocation, sw.getTotalTimeMillis());
		return returnValue;
	}

	private void dumpInfo(MethodInvocation invocation, long ms) {
		Method m = invocation.getMethod();
		Object target = invocation.getThis();
		Object[] args = invocation.getArguments();

		logger.info("Executed method: " + m.getName());
		logger.info("On object of type: " + target.getClass().getName());

		logger.info("With arguments:");
		for (int x = 0; x < args.length; x++) {
			System.out.print("       > " + args[x]);
		}
		System.out.print("\n");

		logger.info("Took: " + ms + " ms");
	}
}
