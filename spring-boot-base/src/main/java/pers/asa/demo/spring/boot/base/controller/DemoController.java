package pers.asa.demo.spring.boot.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/20 19:25
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/20 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
public class DemoController {
    @GetMapping("/demo")
    public String demo() {
        return "demo";
    }
}

