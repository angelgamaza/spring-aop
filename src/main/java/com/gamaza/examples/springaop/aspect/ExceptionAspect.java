package com.gamaza.examples.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAspect {

    // Logger
    private static final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

    /**
     * Poincuts
     */
    @Pointcut("@annotation(com.gamaza.examples.springaop.annotation.AspectExecution)")
    private void exceptionPointcut() {
        // Pointcut definition
    }

    @AfterThrowing(value = "exceptionPointcut()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        // Variables to use
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        // Logs
        logger.info("Exception in [{}.{}()] with message: {}", className, methodName, exception.getMessage());
    }

}
