package com.gamaza.examples.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    // Logger
    private static final Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

    @Pointcut("execution(* com.gamaza.examples.springaop.service.performance.*.*(..))")
    private void performancePointcut() {
        // Pointcut definition
    }

    @Around(value = "performancePointcut()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;

        logger.info("[{}.{}] executed in {} ms", className, methodName, executionTime);
        return result;
    }

}
