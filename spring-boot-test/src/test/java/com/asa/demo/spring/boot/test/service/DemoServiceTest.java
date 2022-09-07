package com.asa.demo.spring.boot.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: this is the demo for the test case used by @contextConfiguration
 * @date: Created at 11:28 2019/8/27.
 */
@RunWith(SpringRunner.class)
//@ContextConfiguration(classes =BeanDIConf.class)
@ContextConfiguration(classes = DemoServiceTest.TestConfig.class)
public class DemoServiceTest {
    @Autowired
    private DemoService demoService;

    @Autowired
    private List<IService> iServices;

    @Test
    public void testIntroduce() {
        System.out.println(demoService.introduce());
    }

    @Test
    public void doService() {
        iServices.forEach(IService::doService);
    }

    @Configuration
    @ComponentScan("com.asa.demo.spring.*")
    public static class TestConfig {

    }
}