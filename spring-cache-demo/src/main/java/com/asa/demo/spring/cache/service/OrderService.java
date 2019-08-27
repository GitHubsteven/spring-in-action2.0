package com.asa.demo.spring.cache.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.CachePut;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:49 2019/8/27.
 */
@Setter
@Getter
public class OrderService {
    @CachePut(value = "order")
    public String order(String orderId) {
        return "newOrder";
    }
}