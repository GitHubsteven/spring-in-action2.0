package com.asa.demo.spring.apache.flume;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.Executors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 17:37 2020/1/14.
 */
public class Main {
    public static void main(String[] args) {
        Executors.newSingleThreadScheduledExecutor(new ThreadFactoryBuilder().setNameFormat("").build());
    }
}