package com.asa.demo.spring.boot.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 10:54 2019/8/27.
 */
public class HelloServiceTest extends BaseServiceTest {
    @Autowired
    private HelloService helloService;

    @Test
    public void testHello() {
        System.out.println(helloService.hi("asa.x"));
    }
}