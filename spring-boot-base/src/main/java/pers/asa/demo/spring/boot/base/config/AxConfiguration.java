package pers.asa.demo.spring.boot.base.config;

import org.springframework.context.annotation.Bean;
import pers.asa.demo.spring.boot.base.bean.AxBeanAware;
import pers.asa.demo.spring.boot.base.service.DemoService;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/20 15:40
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/20 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class AxConfiguration {

    @Bean
    public AxCfgService axService() {
        return new AxCfgService();
    }

    public static class AxCfgService implements DemoService {
        @Override
        public void demo() {
            System.out.println("ax config service...");
        }
    }

    @Bean
    public AxBeanAware axBeanAware() {
        return new AxBeanAware("AxBeanAware");
    }
}

