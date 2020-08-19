package com.asa.demo.spring.security.jwt.shiro.service;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Authoer: asa.x
 * @Date: 2020/7/22
 * @Descrition:
 */
@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public void updateUser() {
        logger.info("--------->update user!");
    }
}
