package com.asa.demo.spring.security.jwt.shiro;

import org.apache.shiro.spring.boot.autoconfigure.ShiroAnnotationProcessorAutoConfiguration;
import org.apache.shiro.spring.boot.autoconfigure.ShiroAutoConfiguration;
import org.apache.shiro.spring.boot.autoconfigure.ShiroBeanAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/6/29
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@SpringBootApplication(exclude = {ShiroAnnotationProcessorAutoConfiguration.class,
        ShiroAutoConfiguration.class, ShiroBeanAutoConfiguration.class})
public class SpringShiroApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringShiroApplication.class, args);
    }
}
