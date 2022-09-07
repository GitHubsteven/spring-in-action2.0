package com.asa.demo.spring.session.redis.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/12/17
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class RedisPerformanceService {
    private final StringRedisTemplate stringRedisTemplate;
    private static final Object lock = new Object();

    public RedisPerformanceService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public String getAndInc() {
        synchronized (lock) {
            String no = stringRedisTemplate.opsForValue().get("no");
            assert no != null;
            stringRedisTemplate.opsForValue().set("no", String.valueOf(Integer.parseInt(no) + 1));
            return no;
        }
    }
}
