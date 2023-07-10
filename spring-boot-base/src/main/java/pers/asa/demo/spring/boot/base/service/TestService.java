package pers.asa.demo.spring.boot.base.service;

import org.springframework.stereotype.Service;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/4/28 11:12
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/4/28 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class TestService {
    public String test() {
        System.out.println(">>>>> test");
        return "TestService";
    }
}

