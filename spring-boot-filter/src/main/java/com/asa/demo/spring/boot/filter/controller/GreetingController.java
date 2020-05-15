package com.asa.demo.spring.boot.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @date: Created at 18:40 2019/8/30.
 */
@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @GetMapping("/hi")
    public String greet(@RequestParam String name) {
        return "greet " + name;
    }

    @GetMapping("/holiday")
    public String holiday(@RequestParam String name) {
        return String.format("hi, %s, have a good holiday!", name);
    }
}