package com.asa.demo.spring.boot.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/9/24
 * @description
 * @copyright COPYRIGHT © 2014 - VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController()
@RequestMapping("/inherit/respective")
public class RespectiveController {
    @GetMapping("/get-string")
    public String getStr() {
        return "get-string";
    }

}
