package pers.asa.demo.spring.boot.base.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pers.asa.demo.spring.boot.base.config.AxComponentConfig;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/20 19:05
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/20 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class Main {
    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AxComponentConfig.class);
        final TestService testService = context.getBean(TestService.class);
        testService.test();
    }
}

