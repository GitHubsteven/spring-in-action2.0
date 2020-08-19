package com.asa.demo.spring.security.jwt.shiro.service;

import com.asa.demo.spring.security.jwt.shiro.ApplicationBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends ApplicationBaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void testUpdateUser() {
        userService.updateUser();
    }

}