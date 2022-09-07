package pers.asa.spring.loader.seq.axservice;

import pers.asa.spring.loader.seq.annotation.AxService;

import java.util.concurrent.TimeUnit;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/8/6 18:48
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/8/6 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@AxService
public class AxDemoService {

    public AxDemoService() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1L);
        System.out.println(">>>>>Lading axService......");
    }
}

