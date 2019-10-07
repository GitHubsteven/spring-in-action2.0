package com.asa.demo.mybatis.mysql;

import com.asa.demo.mybatis.mysql.dao.UserDao;
import com.asa.demo.mybatis.mysql.model.UserModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Authoer: asa.x
 * @Date: 2019/10/7
 * @Descrition:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testSaveUser() {
        int count = userDao.insert("java", "java@qq.com");
        System.out.println(count);
    }

    @Test
    public void testFindAll() {
        List<UserModel> users = userDao.findAll();
        for (UserModel it : users) {
            System.out.println(String.format("username:%s,email:%s", it.getName(), it.getEmail()));
        }
    }

    @Test
    public void testFindById() {
        UserModel user = userDao.findById(4);
        System.out.println(user.getName());
    }
}
