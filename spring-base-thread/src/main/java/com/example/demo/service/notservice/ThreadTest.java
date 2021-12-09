package com.example.demo.service.notservice;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/10/20
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/6/24 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class ThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread("test");
        Thread.State state = thread.getState();
    }
}
