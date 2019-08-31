package com.asa.demo.spring.boot.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author: asaland
 * @date: 2019/8/31
 * @time: 12:35
 * @version: 1.0.0
 * @description:
 **/
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }
}
