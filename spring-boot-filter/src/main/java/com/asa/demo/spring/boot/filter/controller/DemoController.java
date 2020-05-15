package com.asa.demo.spring.boot.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @date: Created at 17:31 2019/8/30.
 */
@RestController
@RequestMapping("/filter/demo")
public class DemoController {
    @GetMapping("/hi")
    public String hi() {
        return "hello,world";
    }
}