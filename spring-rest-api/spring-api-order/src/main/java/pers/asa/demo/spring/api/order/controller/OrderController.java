package pers.asa.demo.spring.api.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/13
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
@RequestMapping("/service/order")
public class OrderController {
    @GetMapping("/getOne")
    public String getOne() {
        return "order-" + new Random().nextInt(1000);
    }
}
