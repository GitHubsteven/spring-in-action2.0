package pers.idv.spring.service.inject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.idv.spring.service.inject.demo.DataBean;
import pers.idv.spring.service.inject.service.DataServiceImpl;
import pers.idv.spring.service.inject.service.IService;
import pers.idv.spring.service.inject.service.MockDataServiceImpl;

/**
 * @version 1.0.0
 * @author: rongbin.xie
 * @date: 2020/4/26
 * @description:
 * @copyright: COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@SpringBootApplication
public class SpringServiceInjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringServiceInjectApplication.class, args);
    }

    @ConditionalOnMissingBean(MockDataServiceImpl.class)
    @Configuration
    static class BeanConfig {
        @Bean
        IService<DataBean> getDataBeanService() {
            return new DataServiceImpl();
        }

        @Bean
        DataServiceImpl getDataServiceImpl() {
            return new DataServiceImpl();
        }
    }
}
