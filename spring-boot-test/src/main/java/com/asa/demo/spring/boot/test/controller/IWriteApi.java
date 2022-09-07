package com.asa.demo.spring.boot.test.controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/9/24
 * @description
 * @copyright COPYRIGHT © 2014 - VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface IWriteApi {
    @GetMapping("/write")
    String write();
}
