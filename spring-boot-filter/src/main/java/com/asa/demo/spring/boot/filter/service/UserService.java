package com.asa.demo.spring.boot.filter.service;

import com.asa.demo.spring.boot.filter.bean.User;
import org.springframework.stereotype.Service;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/6/30
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class UserService implements IUserService {

    @Override
    public User findUserByLoginToken(String token) {
        return null;
    }
}
