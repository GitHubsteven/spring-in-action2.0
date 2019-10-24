package pers.demo.asa.spring.data.mybatis.plus.mysql.service;

import jdk.nashorn.internal.AssertsEnabled;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import pers.demo.asa.spring.data.mybatis.plus.mysql.model.User;

import java.util.List;

import static org.junit.Assert.*;

public class UserServiceImplTest extends BaseServiceTest {

    @Autowired
    @Qualifier("userServiceImpl")
    private IUserService iUserService;

    @Before
    public void setUp() throws Exception {
        logger.info("-------> set up before test");
    }

    @Test
    public void listUsers() {
        List<User> users = iUserService.listUsers(null);
        Assert.assertEquals(3, users.size());
        users.forEach(System.out::println);
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setEmail("mybatis-plus-generator@qq.com");
        user.setName("UserServiceImplTest");
        iUserService.saveUser(user);
    }
}