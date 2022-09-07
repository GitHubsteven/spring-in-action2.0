package com.asa.demo.spring.boot.test.service;

import org.springframework.stereotype.Service;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/20
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class ProductServiceImpl implements IService {
    @Override
    public void doService() {
        System.out.println("--------> product service");
    }
}
