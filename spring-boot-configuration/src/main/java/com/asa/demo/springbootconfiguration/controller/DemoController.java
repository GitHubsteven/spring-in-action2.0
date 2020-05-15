package com.asa.demo.springbootconfiguration.controller;

import com.asa.demo.springbootconfiguration.SpringBootConfigurationApplication;
import com.asa.demo.springbootconfiguration.bean.PostBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author asa.x
 * @date: Created at 14:12 2020/3/4.
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Value("${self.params.defaultUrl}")
    private String defaultUrl;

    private final SpringBootConfigurationApplication.SelfConfigProperties selfConfigProperties;

    public DemoController(SpringBootConfigurationApplication.SelfConfigProperties selfConfigProperties) {
        this.selfConfigProperties = selfConfigProperties;
    }


    @GetMapping("/configuration")
    public Map<String, Object> getConfiguration() {
        Map<String, Object> params = new HashMap<>();
        params.put("defaultUrl", defaultUrl);
        params.put("bizUrls", selfConfigProperties.getBiz());
        return params;
    }

    @PostMapping("/requestBody")
    public PostBean byRequestBody(@RequestBody PostBean params) {
        params.setReceived(!StringUtils.isEmpty(params.getName()) && params.getAge() != null);
        return params;
    }

    @PostMapping("/requestParameter")
    public PostBean byRequestParameter(@RequestParam(value = "name", required = false) String name,
                                       @RequestParam(value = "age", required = false) Integer age) {
        PostBean response = new PostBean();
        response.setName(name);
        response.setAge(age);
        response.setReceived(!StringUtils.isEmpty(name) && age != null);
        return response;
    }

    @PostMapping("/together")
    public PostBean together(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "age", required = false) Integer age,
                             @RequestBody PostBean request) {
        PostBean response = new PostBean();
        response.setName(name);
        response.setAge(age);
        response.setReceived(!StringUtils.isEmpty(name) && age != null);
        response.setExtendsInfo(request);
        return response;
    }


}