package com.asa.demo.spring.aspect.bean;

/**
 * UserContextThreadLocal
 * Created by Chuanyu liang on 2017-01-03.
 *
 * @author Chuanyu liang
 * @version 3.0.0
 */
public class UserContextThreadLocal {

    private static ThreadLocal<UserContext> threadLocalCache = new InheritableThreadLocal<>();

    public static UserContext get() {
        return threadLocalCache.get();
    }

    public static void set(UserContext value) {
        threadLocalCache.set(value);
    }

}
