package com.example.demo.service.notservice;

import com.example.demo.model.UserContext;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 13:32 2018/11/8.
 */
public class ThreadTestService {
    private static ThreadLocal<UserContext> userCache = ThreadLocal.withInitial(UserContext::new);
    private UserContext user;

    public static void main(String[] args) {
        ThreadTestService service = new ThreadTestService();
        service.setName("asaland");
        System.out.println(service.getName());
    }

    public String getName() {
        System.out.println("thread name: " + Thread.currentThread().getName());
        return user == null ? null : user.getName();
    }

    public void setName(String name) {
        System.out.println("thread name: " + Thread.currentThread().getName());
        if (user == null) user = new UserContext();
        user.setName(name);
    }
}