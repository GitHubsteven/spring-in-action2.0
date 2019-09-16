package com.asa.demo.spring.cache.controller;

import com.asa.demo.spring.cache.model.mysql.UserModel;
import com.asa.demo.spring.cache.repository.mysql.UserRepository;
import com.asa.demo.spring.cache.support.ComUser;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * @Authoer: asa.x
 * @Date: 2019/9/15
 * @Descrition:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ComUser comUser;

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
