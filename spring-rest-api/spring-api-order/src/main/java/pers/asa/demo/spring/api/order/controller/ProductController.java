package pers.asa.demo.spring.api.order.controller;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/13
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
@RequestMapping("/service/product")
public class ProductController {
    @GetMapping("/get")
    public String getProduct() {
        return "product" + RandomUtils.nextInt(0, 1000);
    }

    @DeleteMapping("/remove/{id}")
    public Boolean deleteProduct(@PathVariable("id") Integer id) {
        return id > 100;
    }
}
