package com.asa.demo.spring.cache.service;

import com.asa.demo.spring.cache.bean.Customer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @date: Created at 16:04 2019/8/27.
 */
@Service
public class AddressService extends BaseService {

    private final AtomicInteger count = new AtomicInteger(1);

    @Cacheable(value = "address", key = "#customer.name")
    public String getAddress(Customer customer) {
        logger.info("enter the get address method ...");
        String time = String.format("%d", System.currentTimeMillis());
        return customer.getAddress() + time.substring(time.length() - 8) + "c" + count.getAndIncrement();
    }

}