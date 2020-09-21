package com.asa.demo.spring.message.rabbitmq.component;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/9/9
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Component
public class Receiver {
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
