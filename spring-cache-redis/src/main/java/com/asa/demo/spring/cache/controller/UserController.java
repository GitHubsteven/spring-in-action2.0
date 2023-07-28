package com.asa.demo.spring.cache.controller;

import com.asa.demo.spring.cache.model.mysql.UserModel;
import com.asa.demo.spring.cache.repository.mysql.UserRepository;
import com.asa.demo.spring.cache.service.StudentService;
import com.asa.demo.spring.cache.service.UserService;
import com.asa.demo.spring.cache.support.ComUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.*;

/**
 * @author: asa.x
 * @date: 2019/9/15
 * @descrition:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController implements ApplicationContextAware {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserRepository userRepository;
    private final ComUser comUser;

    private ApplicationContext context;

    private final UserService userService;

    public UserController(UserRepository userRepository, ComUser comUser, UserService userService) {
        this.userRepository = userRepository;
        this.comUser = comUser;
        this.userService = userService;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
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

    /**
     * 通过getBean来处理
     */
    @PutMapping("/transaction-getBean")
    public Boolean transaction() {
        UserService studentServiceBean = context.getBean(UserService.class);
        studentServiceBean.saveAndDelete();
        return true;
    }

    @PutMapping("/transaction-autowired")
    public Boolean transaction2() {
        userService.saveAndDelete();
        return true;
    }

    @PutMapping("/transaction-direct")
    public Boolean transaction3() {
        UserModel user = UserService.getUserModel();
        userService.saveAndDelete(user);
        return true;
    }
}
