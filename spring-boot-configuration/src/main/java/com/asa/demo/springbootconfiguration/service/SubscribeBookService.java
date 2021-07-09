package com.asa.demo.springbootconfiguration.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/7 10:14
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/7 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@ConditionalOnProperty(prefix = "config.property", name = "subscribe", havingValue = "book")
@Service
public class SubscribeBookService implements ISubscribeService {
    private final DemoService demoService;

    public SubscribeBookService(DemoService demoService) {
        this.demoService = demoService;
    }

    public void subscribe() {
        demoService.demo();
        System.out.println(">>>>> subscribe book!");
    }
}

