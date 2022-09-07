package com.asa.demo.spring.session.redis.controller;

import com.asa.demo.spring.session.redis.service.RedisPerformanceService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/12/17
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
@RequestMapping("/redis")
public class RedisPerformanceController {
    private final RedisPerformanceService redisPerformanceService;

    public RedisPerformanceController(RedisPerformanceService redisPerformanceService) {
        this.redisPerformanceService = redisPerformanceService;
    }

    @PutMapping("/getAndInc")
    public String getIncrement() {
        return redisPerformanceService.getAndInc();
    }
}
