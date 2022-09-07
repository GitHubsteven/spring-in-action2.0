package com.asa.demo.mybatis.mysql;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @date: Created at 10:58 2019/10/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BaseTest {
    Map<String, Object> cache = new ConcurrentHashMap<>();

    @Test
    public void testCacheWith() {
        cache.computeIfAbsent("x", (key) -> null);
    }
}