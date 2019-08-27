package com.asa.demo.spring.boot.test.service;

import org.springframework.stereotype.Service;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 11:27 2019/8/27.
 */
@Service
public class DemoService {
    public String introduce() {
        return "hi, this is demo!";
    }
}