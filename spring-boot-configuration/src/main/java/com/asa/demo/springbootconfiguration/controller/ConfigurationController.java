package com.asa.demo.springbootconfiguration.controller;

import com.asa.demo.springbootconfiguration.SpringBootConfigurationApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version 1.0.0
 * @author: rongbin.xie
 * @date: 2020/4/17
 * @description:
 * @CopyRight: COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
@RequestMapping("/self-config")
public class ConfigurationController {
    private final SpringBootConfigurationApplication.SelfConfigProperties properties;

    public ConfigurationController(SpringBootConfigurationApplication.SelfConfigProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/get-companyIds")
    public List<Integer> getCompanyIds() {
        return properties.getCompanyIds();
    }
}
