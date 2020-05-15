package com.asa.demo.spring.cache.service;

import com.asa.demo.spring.cache.model.mysql.UserModel;
import com.asa.demo.spring.cache.support.ComUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @version 1.0.0
 * @author: rongbin.xie
 * @date: 2020/5/14
 * @description:
 * @copyright: COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class ComUserTest extends BaseServiceTest {
    @Autowired
    private ComUser comUser;

    @Test
    public void testSaveUser() {
        UserModel user = comUser.getUserById(1);
        System.out.println(user.toString());
    }
}
