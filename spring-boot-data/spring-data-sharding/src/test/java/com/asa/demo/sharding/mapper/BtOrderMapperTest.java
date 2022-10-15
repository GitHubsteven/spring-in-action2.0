package com.asa.demo.sharding.mapper;

import com.asa.demo.sharding.ShardingAppTest;
import com.asa.demo.sharding.domain.BtOrderItemModel;
import com.asa.demo.sharding.domain.BtOrderModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class BtOrderMapperTest extends ShardingAppTest {
    @Autowired
    private BtOrderMapper btOrderMapper;
    @Autowired
    private BtOrderItemMapper btOrderItemMapper;


    @Test
    public void testCreateOrder() {
        for (int i = 10; i < 14; i++) {
            BtOrderModel order = new BtOrderModel();
            order.setOrderNo("A000" + i);
            order.setCreateName("订单 " + i);
            order.setPrice(new BigDecimal("" + i));
            btOrderMapper.insert(order);

            BtOrderItemModel orderItem = new BtOrderItemModel();
            orderItem.setOrderId(order.getOrderId());
            orderItem.setOrderNo("A000" + i);
            orderItem.setItemName("服务项目" + i);
            orderItem.setPrice(new BigDecimal("" + i));
            btOrderItemMapper.insert(orderItem);
        }
    }
}