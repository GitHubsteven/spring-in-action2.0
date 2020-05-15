package com.asa.demo.mybatis.mysql;

import com.asa.demo.mybatis.mysql.dao.UserDao;
import com.asa.demo.mybatis.mysql.model.UserModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: asa.x
 * @date: 2019/10/7
 * @descrition:
 */
public class UserDaoTest extends BaseTest {
    @Autowired
    private UserDao userDao;    //忽略，除非运行时异常

    @Test
    public void testSaveUser() {
        String prefix = "python";
        int count = userDao.insert(prefix, prefix + "@qq.com");
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

    @Test
    public void testCountUser() {
        System.out.println(userDao.countUser());
    }

    @Test
    public void testGetById() {
        UserModel user = userDao.getById(1L);
        System.out.println(user.getName());
    }
}
