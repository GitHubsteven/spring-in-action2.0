package com.asa.demo.spring.boot.mysql.service;

import com.asa.demo.spring.boot.mysql.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        User user = new User();
        user.setName("mysql");
        user.setEmail("root@mysql.com");
        Integer id = userService.addUser(user);
        System.out.println(id);
    }

    @Test
    public void getById() {
    }
}