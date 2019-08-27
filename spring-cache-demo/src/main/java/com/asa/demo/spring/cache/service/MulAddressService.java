package com.asa.demo.spring.cache.service;

import com.asa.demo.spring.cache.bean.Customer;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:52 2019/8/27.
 */
@Service
public class MulAddressService {
    /**
     * What if you want to use multiple annotations of the same type for caching a method.
     * As shown in the code snippet below, you can group multiple caching annotations with @Caching,
     * and use it to implement your own customized caching logic.
     *
     * @param customer customer info
     * @return address
     */
    @Caching(evict = {@CacheEvict("address"), @CacheEvict(value = "directory", key = "#customer.name")})
    public String getAddress(Customer customer) {
        return "";
    }
}