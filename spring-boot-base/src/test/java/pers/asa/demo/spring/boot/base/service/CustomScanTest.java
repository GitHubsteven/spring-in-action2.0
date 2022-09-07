package pers.asa.demo.spring.boot.base.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.asa.demo.spring.boot.base.config.AxComponentConfig;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/20 18:49
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/20 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AxComponentConfig.class})
public class CustomScanTest {
    @Autowired
    private TestService testService;

    @Test
    public void demo() {
        testService.test();
    }
}

