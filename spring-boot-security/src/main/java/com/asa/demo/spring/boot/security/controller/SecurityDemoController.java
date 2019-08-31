package com.asa.demo.spring.boot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: asaland
 * @date: 2019/8/31
 * @time: 12:39
 * @version: 1.0.0
 * @description:
 **/
@RestController
@RequestMapping("/security")
public class SecurityDemoController {
    @GetMapping("/hi")
    public String hi() {
        return "hi,spring boot security!";
    }
}
