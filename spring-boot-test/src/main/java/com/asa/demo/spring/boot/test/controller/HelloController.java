package com.asa.demo.spring.boot.test.controller;

import com.asa.demo.spring.boot.test.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 10:39 2019/8/27.
 */
@RestController
@RequestMapping("/hi")
public class HelloController {
    @Autowired
    private HelloService helloService;

    @GetMapping("/home")
    public String home() {
        return helloService.hi("asa.x") + "welcome to home!";
    }
}