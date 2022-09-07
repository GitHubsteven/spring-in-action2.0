package pers.asa.demo.spring.boot.base.factory;

import pers.asa.demo.spring.boot.base.service.DemoService;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/20 17:33
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/20 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class RegisterService implements DemoService {

    private final Integer id;

    public RegisterService(Integer id) {
        this.id = id;
    }

    @Override
    public void demo() {
        System.out.printf(">>>>> register service [%s]...%n", id);
    }
}

