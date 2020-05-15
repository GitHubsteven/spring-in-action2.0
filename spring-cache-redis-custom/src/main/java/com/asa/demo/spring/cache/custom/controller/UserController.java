package com.asa.demo.spring.cache.custom.controller;

import com.asa.demo.spring.cache.custom.model.mysql.UserModel;
import com.asa.demo.spring.cache.custom.repository.mysql.UserRepository;
import com.asa.demo.spring.cache.custom.support.ComUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @author: asa.x
 * @date: 2019/9/15
 * @descrition:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserRepository userRepository;
    private final ComUser comUser;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserRepository userRepository, ComUser comUser) {
        this.userRepository = userRepository;
        this.comUser = comUser;
    }

    /**
     * 保存用户
     *
     * @param user 新用户
     * @return 用户id
     */
    @PostMapping("/save")
    public Integer saveUser(@RequestBody UserModel user) {
        return userRepository.save(user).getId();
    }

    /**
     * 通过id来查询用户
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/findById/{id}")
    public UserModel findById(@PathVariable("id") Integer id) {
        return comUser.getUserById(id);
    }

}
