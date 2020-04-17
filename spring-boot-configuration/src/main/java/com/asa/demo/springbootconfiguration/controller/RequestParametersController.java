package com.asa.demo.springbootconfiguration.controller;

import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0
 * @author: rongbin.xie
 * @date: 2020/3/25
 * @CopyRight: COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
@RequestMapping("/request-param")
public class RequestParametersController {
    @PostMapping("/by-map")
    public Map<String, Object> getParamsByMap(@RequestParam Map<String, Object> params) {
        boolean isReceive = false;
        Map<String, Object> result;
        if (!CollectionUtils.isEmpty(params)) {
            isReceive = true;
            result = params;
        } else {
            result = new HashMap<>(0);
        }
        result.put("isReceive", isReceive);
        return result;
    }
}
