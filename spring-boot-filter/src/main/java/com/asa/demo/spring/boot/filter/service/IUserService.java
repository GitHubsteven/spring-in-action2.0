package com.asa.demo.spring.boot.filter.service;

import com.asa.demo.spring.boot.filter.bean.User;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/6/30
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface IUserService {
    /**
     * 根据token获取用户信息
     *
     * @param token token
     * @return user 信息
     */
    User findUserByLoginToken(String token);
}
