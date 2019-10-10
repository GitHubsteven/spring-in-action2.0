package com.asa.demo.spring.session.redis;

import com.asa.demo.spring.session.redis.config.DIConfig;
import com.asa.demo.spring.session.redis.config.RedisConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 16:05 2019/9/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DIConfig.class, RedisConfig.class})
public class TestRedis {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
//    @Autowired
//    private RedisTemplate redisTemplate;

    @Test
    public void testOps() {
        stringRedisTemplate.opsForValue().set("aaa", "1111");
        Assert.assertEquals("1111", stringRedisTemplate.opsForValue().get("aaa"));
    }
}