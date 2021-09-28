package com.asa.demo.spring.boot.test.controller.delegate;

import org.springframework.stereotype.Component;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/9/24
 * @description
 * @copyright COPYRIGHT © 2014 - VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Component
public class WriteConductor implements IWrite {
    @Override
    public String write() {
        return "write by conductor withdraw api";
    }
}
