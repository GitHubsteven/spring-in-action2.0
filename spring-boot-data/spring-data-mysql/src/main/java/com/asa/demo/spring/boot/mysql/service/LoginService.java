package com.asa.demo.spring.boot.mysql.service;

import com.asa.demo.spring.boot.mysql.model.Session;
import com.asa.demo.spring.boot.mysql.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author: asa.x
 * @date: 2019/12/17
 * @descrition:
 */
@Service
public class LoginService {
    @Autowired
    private UserService userService;
    @Autowired
    private SessionsService sessionsService;

    @Transactional
    public void login(String username, String password) {
        User user = new User();
        user.setName(username);
        user.setEmail(password);
        userService.addUser(user);
        if ("exception".equalsIgnoreCase(username))
            throw new IllegalArgumentException("username is wrong!");
        Session session = new Session();
        session.setSessionId(UUID.randomUUID().toString());
        session.setRemark("test for transaction!");
        sessionsService.add(session);
    }
}
