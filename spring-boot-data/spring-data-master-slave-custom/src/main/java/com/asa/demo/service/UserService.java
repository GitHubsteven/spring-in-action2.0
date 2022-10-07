/**
 * @author: asa.x
 * @date: 2022/9/7
 * @descrition:
 */
package com.asa.demo.service;

import com.asa.demo.dao.UserDao;
import com.asa.demo.repository.UserRepository;
import com.asa.demo.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDao userDao;

    public UserService(UserRepository userRepository, UserDao userDao) {
        this.userRepository = userRepository;
        this.userDao = userDao;
    }

    public UserModel getById(Integer id) {
        return userRepository.getOne(id);
    }

    public UserModel getByIdMybatis(Integer id) {
        return userDao.findById(id);
    }
}
