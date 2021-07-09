package com.asa.demo.springbootconfiguration.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SubscribeServiceTest {
    @Autowired
    private ISubscribeService iSubscribeService;

    @Test
    public void subscribeBook() {
        iSubscribeService.subscribe();
    }
}