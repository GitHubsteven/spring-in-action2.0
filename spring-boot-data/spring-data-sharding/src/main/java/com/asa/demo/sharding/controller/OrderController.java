/**
 * @author: asx
 * @date: 2022/9/17
 * @descrition:
 */
package com.asa.demo.sharding.controller;


import com.asa.demo.sharding.domain.BtOrderModel;
import com.asa.demo.sharding.service.BtOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/master/slave/sharding/order")
public class OrderController {
    private final BtOrderService btOrderService;

    public OrderController(BtOrderService btOrderService) {
        this.btOrderService = btOrderService;
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id) {
        BtOrderModel order = btOrderService.getById(id);
        return order.getOrderNo();
    }
}
