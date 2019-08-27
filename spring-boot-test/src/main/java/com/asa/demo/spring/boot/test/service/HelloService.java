package com.asa.demo.spring.boot.test.service;

import org.springframework.stereotype.Service;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 10:41 2019/8/27.
 */
@Service
public class HelloService {
    public String hi(String name) {
        return String.format("hi,%s", name);
    }
}