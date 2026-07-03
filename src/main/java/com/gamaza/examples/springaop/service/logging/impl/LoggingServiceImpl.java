package com.gamaza.examples.springaop.service.logging.impl;

import com.gamaza.examples.springaop.service.logging.LoggingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoggingServiceImpl implements LoggingService {

    // Logger
    private static final Logger logger = LoggerFactory.getLogger(LoggingServiceImpl.class);

    @Override
    public void action1() {
        logger.info("Action 1");
    }

    @Override
    public void action2() {
        logger.info("Action 2");
    }

    @Override
    public String action3() {
        logger.info("Action 3");
        return UUID.randomUUID().toString();
    }

}
