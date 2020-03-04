package com.asa.demo.springbootconfiguration.controller;

import com.asa.demo.springbootconfiguration.SpringBootConfigurationApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author asa.x
 * @Date: Created at 14:12 2020/3/4.
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Value("${self.params.defaultUrl}")
    private String defaultUrl;

    @Autowired
    private SpringBootConfigurationApplication.SelfConfigProperties selfConfigProperties;


    @GetMapping("/configuration")
    public Map<String, Object> getConfiguration() throws IOException {
        Map<String, Object> params = new HashMap<>();
        params.put("defaultUrl", defaultUrl);
        params.put("bizUrls", selfConfigProperties.getBiz());
        return params;
    }
}