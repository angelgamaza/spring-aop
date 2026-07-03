package com.gamaza.examples.springaop.service.performance.impl;

import com.gamaza.examples.springaop.service.performance.PerformanceService;
import org.springframework.stereotype.Service;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Override
    public void action1() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Override
    public void action2() throws InterruptedException {
        for (int i = 0; i < 100000; ++i) {
            if (i % 1000 == 0) {
                Thread.sleep(100);
            }
        }
    }

}
