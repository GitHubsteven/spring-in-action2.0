package pers.asa.spring.loader.seq.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/8/6 18:48
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/8/6 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class DemoService {
    public DemoService() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1L);
        System.out.println(">>>>>Lading spring service......");
    }
}

