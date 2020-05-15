package com.asa.demo.spring.boot.test.controller;

import com.asa.demo.spring.boot.test.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @date: Created at 10:39 2019/8/27.
 */
@RestController
@RequestMapping("/hi")
public class HelloController {
    @Autowired
    private HelloService helloService;

    public static int count = 0;

    @GetMapping("/home")
    public String home() {
        return helloService.hi("asa.x") + "welcome to home!";
    }

    @PutMapping("/users/{id}")
    public boolean updateUser(@RequestBody Map<String, String> parameters) {
        return true;
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteUser() {
        return true;
    }

    @GetMapping("/session")
    public int sessionTrace() {
        return count++;
    }
}