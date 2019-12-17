package com.asa.demo.spring.boot.mysql.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class LoginServiceTest extends BaseServiceTest {
    @Autowired
    private LoginService loginService;

    @Test
    public void login() {
        loginService.login("exception","test-exp");
    }
}