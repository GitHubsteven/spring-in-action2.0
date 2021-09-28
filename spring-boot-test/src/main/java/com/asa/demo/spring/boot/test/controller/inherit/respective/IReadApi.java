package com.asa.demo.spring.boot.test.controller.inherit.respective;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/9/24
 * @description
 * @copyright COPYRIGHT © 2014 - VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface IReadApi {
    @PostMapping("/get-map")
    Map<String, Object> getMap();
}
