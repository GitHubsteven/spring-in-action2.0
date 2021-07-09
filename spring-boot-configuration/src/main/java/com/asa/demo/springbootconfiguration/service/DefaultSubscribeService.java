package com.asa.demo.springbootconfiguration.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/7 17:00
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/7 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
//@ConditionalOnMissingBean(value = {SubscribeBookService.class, SubscribePaperService.class})
@ConditionalOnProperty(prefix = "config.property", name = "subscribe", havingValue = "default", matchIfMissing = true)
@Service
public class DefaultSubscribeService implements ISubscribeService {
    @Override
    public void subscribe() {
        System.out.println(">>>>> subscribe default...");
    }
}

