package com.asa.demo.spring.boot.test.controller;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/9/24
 * @description
 * @copyright COPYRIGHT © 2014 - VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class AbsWriteApi implements IWriteApi {
    @Override
    public String write() {
        return "write ...";
    }
}
