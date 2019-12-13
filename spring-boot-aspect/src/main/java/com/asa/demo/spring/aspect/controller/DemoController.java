package com.asa.demo.spring.aspect.controller;

import com.asa.demo.spring.aspect.core.Loggable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:37 2019/9/20.
 */
@RestController
@RequestMapping("/demo")
public class DemoController implements Loggable {
    @RequestMapping("/test")
    public String test() {
        LOGGER.info("---------->>>>>>>>>test");
        return "demo.test";
    }
}