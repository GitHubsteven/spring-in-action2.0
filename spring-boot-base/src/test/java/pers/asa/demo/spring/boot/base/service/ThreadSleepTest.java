/**
 * @author: asx
 * @date: 2023/6/8
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.service;

import com.google.common.util.concurrent.Uninterruptibles;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ThreadSleepTest {

    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS");

    public static void main(String[] args) {
        System.out.println(sdf.format(new Date()));
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        System.out.println(sdf.format(new Date()));
    }
}
