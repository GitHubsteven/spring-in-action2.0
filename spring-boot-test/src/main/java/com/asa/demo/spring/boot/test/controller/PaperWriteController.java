package com.asa.demo.spring.boot.test.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/9/24
 * @description
 * @copyright COPYRIGHT © 2014 - VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@ConditionalOnProperty(value = "api.version", havingValue = "paper")
@RestController
@RequestMapping("/paper")
public class PaperWriteController extends AbsWriteApi {
}
