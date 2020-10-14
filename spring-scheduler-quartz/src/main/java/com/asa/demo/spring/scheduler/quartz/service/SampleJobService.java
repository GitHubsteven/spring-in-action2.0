package com.asa.demo.spring.scheduler.quartz.service;

import org.springframework.stereotype.Service;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/12
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class SampleJobService {
    public void executeSampleJob() {
        System.out.println("This is a quartz job!");
    }
}
