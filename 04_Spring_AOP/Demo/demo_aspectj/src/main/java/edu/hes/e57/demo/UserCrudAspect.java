package edu.hes.e57.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class UserCrudAspect {
	private static Logger logger = LoggerFactory.getLogger(UserCrudAspect.class);

	@Before("execution(* UserManager.getUserById(..))")
	public void logBeforeV1(JoinPoint joinPoint) {
		logger.info("UserCrudAspect.logBeforeV1() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* UserManager.*(..))")
	public void logBeforeV2(JoinPoint joinPoint) {
		logger.info("UserCrudAspect.logBeforeV2() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* UserManager.getUserById(..))")
	public void logAfterV1(JoinPoint joinPoint) {
		logger.info("UserCrudAspect.logAfterV1() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* UserManager.*(..))")
	public void logAfterV2(JoinPoint joinPoint) {
		logger.info("UserCrudAspect.logAfterV2() : " + joinPoint.getSignature().getName());
	}
}
