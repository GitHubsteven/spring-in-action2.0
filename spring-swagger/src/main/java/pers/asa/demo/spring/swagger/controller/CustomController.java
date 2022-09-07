package pers.asa.demo.spring.swagger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.asa.demo.spring.swagger.bean.Customer;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/5 13:44
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/5 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
public class CustomController {

    @RequestMapping(value = "/custom", method = RequestMethod.POST)
    public String custom() {
        return "custom";
    }

    @RequestMapping(value = "/custom", method = RequestMethod.GET)
    public Customer getCustom() {
        return new Customer("foolish", "customerNo-001");
    }
}

