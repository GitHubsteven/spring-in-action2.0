package com.asa.demo.spring.boot.mysql.service;

import com.asa.demo.spring.boot.mysql.model.User;
import com.asa.demo.spring.boot.mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: asa.x
 * @date: 2019/9/13
 * @descrition:
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * 添加用户
     *
     * @param user 用户
     * @return 用户id
     */
    public Integer addUser(User user) {
        User insertUser = userRepository.save(user);
        return insertUser.getId();
    }

    /**
     * 通过userId来查找user
     *
     * @param userId userId
     * @return 用户
     */
    public User getById(Integer userId) {
        return userRepository.findById(String.valueOf(userId)).orElse(null);
    }
}
