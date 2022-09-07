package com.asa.demo.dao;

import com.asa.demo.BaseTest;
import com.asa.demo.model.UserModel;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void listUsers() {
        List<UserModel> users = userDao.listUsers();
        users.forEach((userModel -> {
            System.out.println(userModel.toString());
        }));
    }

    @Test
    public void testInsert() {
        for (int i = 3; i < 6; i++) {
            UserModel user = new UserModel();
            user.setName("user-" + i);
            user.setAge(i);
            userDao.insert(user);
        }
    }

    @Test
    public void testCreateAndGet() {
        Integer id = userDao.createUser("user-insert", 10);
        System.out.println(id);
        UserModel user_1 = userDao.getById(1);
        Assert.assertEquals("user-1", user_1.getName());
    }

    @Test
    public void testGetByIdRound() {
        UserModel user1 = userDao.getByIdRound(1);
        // 再查询
        UserModel user2 = userDao.getByIdRound(1);
        Assert.assertNotEquals(user1.getName(), user2.getName());
    }
}