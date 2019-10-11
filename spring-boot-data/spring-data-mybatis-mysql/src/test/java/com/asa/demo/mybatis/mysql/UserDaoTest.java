package com.asa.demo.mybatis.mysql;

import com.asa.demo.mybatis.mysql.dao.UserDao;
import com.asa.demo.mybatis.mysql.model.UserModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 10:59 2019/10/11.
 */
public class UserDaoTest extends BaseTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testGetUserById() {
        UserModel user = userDao.selectUserById((long) 1);
        System.out.println(user.getName());
    }
}