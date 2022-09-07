package com.example.demo.service;

import com.example.demo.model.UserContext;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 服务类
 * @Date: Created at 16:00 2018/11/1.
 */
@Component
public class HelloService {
    private UserContext userContext = new UserContext();    //在多线程中是会出现问题
    private ThreadLocal<UserContext> userCache = new ThreadLocal<>();

    public void bus1() {

    }

    public String getUser() {
//        UserContext userContext = userCache.get();
//        return userContext == null ? null : userContext.getName();
        //no thread safe
        return userContext.getName();
    }

    public void setUser(String name) {
//        UserContext userContext = userCache.get();
//        if (userContext == null) userContext = new UserContext();
//        userContext.setName(name);
//        userCache.set(userContext);
        // no thread safe
        userContext.setName(name);
    }

    @PreDestroy
    public void voicePreDestroy() {
        System.out.println("HelloService will be destroy");
    }
}