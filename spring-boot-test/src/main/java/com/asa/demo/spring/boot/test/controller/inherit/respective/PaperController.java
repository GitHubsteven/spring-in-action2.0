package com.asa.demo.spring.boot.test.controller.inherit.respective;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/9/24
 * @description
 * @copyright COPYRIGHT © 2014 - VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@ConditionalOnProperty(value = "api.version", havingValue = "paper")
@RestController()
@RequestMapping("/test/inherit/res-paper")
public class PaperController implements IReadApi {
    public Map<String, Object> getMap() {
        Map<String, Object> result = new HashMap<>();
        result.put("read", "paper");
        return result;
    }

    @GetMapping("/get")
    public String getTest() {
        return "get-test";
    }
}
