package com.gamaza.examples.springaop;

import com.gamaza.examples.springaop.service.exception.ExceptionService;
import com.gamaza.examples.springaop.service.logging.LoggingService;
import com.gamaza.examples.springaop.service.performance.PerformanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

    // Logger
    private static final Logger logger = LoggerFactory.getLogger(SpringAopApplication.class);

    // Injection variables
    private final LoggingService loggingService;
    private final PerformanceService performanceService;
    private final ExceptionService exceptionService;

    public SpringAopApplication(LoggingService loggingService, PerformanceService performanceService, ExceptionService exceptionService) {
        this.loggingService = loggingService;
        this.performanceService = performanceService;
        this.exceptionService = exceptionService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringAopApplication.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        // Logging service actions
        logger.info("------ Logging service -------");
        loggingService.action1();
        loggingService.action2();
        String result = loggingService.action3();
        logger.info("Action 3 result: {}", result);

        // Performance service actions
        logger.info("------ Performance service -------");
        performanceService.action1();
        performanceService.action2();

        // Exception service actions
        logger.info("------ Exception service -------");
        try {
            exceptionService.action1();
        } catch (Exception e) {
            logger.error("Catched exception in main method");
        }
    }

}
