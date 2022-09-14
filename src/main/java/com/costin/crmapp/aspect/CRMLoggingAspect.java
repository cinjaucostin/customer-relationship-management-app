package com.costin.crmapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.costin.crmapp.dao.*.*(..))")
    private void pointcutForDAOPackage() {
    }

    @Pointcut("execution(* com.costin.crmapp.service.*.*(..))")
    private void pointcutForServicePackage() {
    }

    @Pointcut("execution(* com.costin.crmapp.controller.*.*(..))")
    private void pointcutForControllerPackage() {
    }

    @Pointcut("pointcutForControllerPackage() || pointcutForServicePackage() || pointcutForDAOPackage()")
    private void pointcutForAppFlow() {
    }

    @Before("pointcutForAppFlow()")
    public void beforeAdvice(JoinPoint joinPoint) {
        // display the method we are calling.
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("======> in @Before: calling method: " + methodName);

        // display the arguments to the method.

        logger.info("======> Method parameters: ");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logger.info(arg.toString());
        }

    }

    @AfterReturning(pointcut = "pointcutForAppFlow()", returning = "theResult")
    public void afterReturningAdvice(JoinPoint joinPoint, Object theResult) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("======> in @AfterReturning: calling method: " + methodName);

        if (theResult != null) {
            logger.info("======> Method result: " + theResult.toString());
        }
    }

}
