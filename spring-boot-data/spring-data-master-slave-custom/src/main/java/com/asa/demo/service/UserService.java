/**
 * @author: asa.x
 * @date: 2022/9/7
 * @descrition:
 */
package com.asa.demo.service;

import com.asa.demo.dao.UserRepository;
import com.asa.demo.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel getById(Integer id) {
        return userRepository.getOne(id);
    }
}
