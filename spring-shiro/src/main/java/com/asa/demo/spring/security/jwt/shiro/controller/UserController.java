package com.asa.demo.spring.security.jwt.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Authoer: asa.x
 * @Date: 2020/7/24
 * @Descrition:
 */
@RestController
public class UserController {
    @RequiresRoles("admin")
    @GetMapping("/api/users")
    public List<String> users() {
        return Arrays.asList("asa.x", "jeff.yin");
    }
}
