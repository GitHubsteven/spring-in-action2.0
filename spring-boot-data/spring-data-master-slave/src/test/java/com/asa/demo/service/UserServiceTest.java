package com.asa.demo.service;

import com.asa.demo.BaseTest;
import org.h2.engine.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void listUsers() {
        userService.listUsers().forEach(userModel -> System.out.println(userModel.getId()));
    }
}