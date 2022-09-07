package com.example.demo.bean;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/9/22
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class BrokenWorker implements Runnable {
    private List<String> outputScraper;
    private CountDownLatch countDownLatch;

    public BrokenWorker(List<String> outputScraper, CountDownLatch countDownLatch) {
        this.outputScraper = outputScraper;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        if (true) {
            throw new RuntimeException("Oh dear, I'm a BrokenWorker");
        }
        doSomeWork();
        outputScraper.add("Counted down");
        countDownLatch.countDown();
    }

    public void doSomeWork() {

    }
}
