package com.asa.demo.springbootconfiguration.controller;

import com.asa.demo.springbootconfiguration.SpringBootConfigurationApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ConfigurationControllerTest {
    @Autowired
    private ConfigurationController configurationController;
    @Autowired
    private SpringBootConfigurationApplication.SelfConfigProperties configurationProperties;

    @Test
    public void get_config() {
        System.out.println(configurationProperties.getPort());
    }

}