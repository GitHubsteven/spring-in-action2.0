package com.asa.demo.spring.cache.service;

import com.asa.demo.spring.cache.bean.Customer;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: This kind of conditional caching can prove quite useful for managing large results and customizing behavior
 * based on input parameters instead of enforcing a generic behavior to all operations.
 * @Date: Created at 17:00 2019/8/27.
 */
@CacheConfig(cacheNames = {"addresses"})
public class CustomerDataService {
    @Cacheable
    public String getAddress(Customer customer) {
        return "";
    }

    @CachePut(value = "addresses", condition = "#customer.name=='Tom'")
    public String getAddress2(Customer customer) {
        return "";
    }

    /**
     * The above annotation would cache addresses unless they are shorter than 64 characters.
     *
     * @param customer customer info
     * @return custom address
     */
    @CachePut(value = "addresses", unless = "#result.length()<64")
    public String getAddress3(Customer customer) {
        return customer.getAddress();
    }

}