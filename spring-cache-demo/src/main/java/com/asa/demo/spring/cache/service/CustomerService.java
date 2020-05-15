package com.asa.demo.spring.cache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @date: Created at 16:45 2019/8/27.
 */
@Service
public class CustomerService {
    @CacheEvict(value = "customer", allEntries = true)
    public String getCustomer(Integer id) {
        return "";
    }
}