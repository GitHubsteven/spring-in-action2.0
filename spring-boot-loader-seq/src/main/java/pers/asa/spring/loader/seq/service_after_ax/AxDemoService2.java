package pers.asa.spring.loader.seq.service_after_ax;

import pers.asa.spring.loader.seq.annotation.AxService;

import java.util.concurrent.TimeUnit;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/8/6 18:53
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/8/6 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@AxService
public class AxDemoService2 {
    public AxDemoService2() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1L);
        System.out.println(">>>>>Lading AxService......");
    }
}

