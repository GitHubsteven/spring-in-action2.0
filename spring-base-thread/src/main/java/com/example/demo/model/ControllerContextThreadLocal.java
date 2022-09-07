package com.example.demo.model;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:52 2018/11/1.
 */
public class ControllerContextThreadLocal {
    private static ThreadLocal<ControllerContext> contextCache = new ThreadLocal<>();

    public static ControllerContext get() {
        return contextCache.get();
    }

    public static void set(ControllerContext context) {
        contextCache.set(context);
    }
}