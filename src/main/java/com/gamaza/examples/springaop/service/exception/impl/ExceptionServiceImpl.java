package com.gamaza.examples.springaop.service.exception.impl;

import com.gamaza.examples.springaop.annotation.AspectExecution;
import com.gamaza.examples.springaop.exception.GenericRuntimeException;
import com.gamaza.examples.springaop.service.exception.ExceptionService;
import org.springframework.stereotype.Service;

@Service
public class ExceptionServiceImpl implements ExceptionService {

    @Override
    @AspectExecution
    public void action1() {
        throw new GenericRuntimeException("Exception in Action 1");
    }

}
