package pers.asa.demo.spring.boot.base.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.asa.demo.spring.boot.base.annotation.EnableConfiguration;
import pers.asa.demo.spring.boot.base.annotation.EnableRegister;
import pers.asa.demo.spring.boot.base.config.AxConfiguration;
import pers.asa.demo.spring.boot.base.factory.RegisterService;

import java.util.Map;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/20 17:12
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/20 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@EnableConfiguration
@EnableRegister
public class EnableTest {
    @Autowired
    private AxConfiguration.AxCfgService axCfgService;
    @Autowired
    private Map<String, RegisterService> registerServices;

    @Test
    public void demo() {
        axCfgService.demo();
    }

    @Test
    public void register() {
        registerServices.forEach((key, service) -> {
            service.demo();
        });
    }
}

