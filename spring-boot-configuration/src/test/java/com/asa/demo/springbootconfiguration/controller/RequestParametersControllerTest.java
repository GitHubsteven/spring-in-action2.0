package com.asa.demo.springbootconfiguration.controller;

import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class RequestParametersControllerTest {
    @Autowired
    private RequestParametersController requestParametersController;

    @Test
    public void getProperties() {
    }

}