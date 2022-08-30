package com.optimum.recommendation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

	@Pointcut("within(com.optimum.recommendation.controller..*)")
	public void loggingPointCut() {
		//pointcut
	}

	@Before("loggingPointCut()")
	public void loggingAdviceBefore(JoinPoint jp) {
		logger.debug("*********Before logging advice-inside method********** {}", jp.getSignature().getName());
	}

	@After("loggingPointCut()")
	public void loggingAdviceAfter(JoinPoint jp) {
		logger.debug("*********After logging advice-inside method***********{}", jp.getSignature().getName());
	}

	@AfterReturning("loggingPointCut()")
	public void loggingAdviceAfterReturning(JoinPoint jp) {
		logger.debug("*********After returning logging advice-inside method**********{}", jp.getSignature().getName());

	}

	@AfterThrowing(value = "loggingPointCut()", throwing = "ex")
	public void loggingAdviceAfterThrowing(JoinPoint jp, Exception ex) {
		logger.debug("**************After throwing logging advice-inside method*********{}", jp.getSignature().getName());
	}

}
