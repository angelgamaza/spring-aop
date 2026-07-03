package com.gamaza.examples.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Logger
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.gamaza.examples.springaop.service.logging..*.*(..))")
    private void loggingPointcut() {
        // Pointcut definition
    }

    @Before(value = "loggingPointcut()")
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("Before method [{}.{}()] execution", className, methodName);
    }

    @After(value = "loggingPointcut()")
    public void after(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("After method [{}.{}()] execution", className, methodName);
    }

    @AfterReturning(value = "loggingPointcut() && !execution(void com.gamaza.examples.springaop.service.logging..*.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("After method [{}.{}()] execution with return value: [{}]", className, methodName, result);
    }

}
