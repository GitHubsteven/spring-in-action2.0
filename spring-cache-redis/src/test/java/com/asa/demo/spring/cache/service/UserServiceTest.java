package com.asa.demo.spring.cache.service;

import com.asa.demo.spring.cache.model.mysql.UserModel;
import com.asa.demo.spring.cache.repository.mysql.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: asa.x
 * @date: 2019/9/15
 * @descrition:
 */
public class UserServiceTest extends BaseServiceTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        UserModel userModel = new UserModel();
        userModel.setEmail("mysql@redis");
        userModel.setName("my-redis");
        UserModel save = userRepository.save(userModel);
        logger.info("---------save user successfully,userId is:{}", save.getId());
    }
}
