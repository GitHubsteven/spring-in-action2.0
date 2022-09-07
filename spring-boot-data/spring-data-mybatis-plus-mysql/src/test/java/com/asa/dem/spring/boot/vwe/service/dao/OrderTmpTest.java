package com.asa.dem.spring.boot.vwe.service.dao;

import com.asa.dem.spring.boot.vwe.dao.OrderTmpDao;
import com.asa.dem.spring.boot.vwe.model.OrderTmp;
import com.asa.dem.spring.boot.vwe.service.BaseServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/23
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class OrderTmpTest extends BaseServiceTest {
    @Autowired
    private OrderTmpDao orderTmpDao;

    @Test
    public void testTmpTable() {
        OrderTmp order1 = new OrderTmp();
        order1.setBatchId("btc-001");
        order1.setOrderId("001");
        order1.setSupplierId("1");
        orderTmpDao.insert(order1);
        OrderTmp order2 = new OrderTmp();
        order2.setBatchId("btc-001");
        order2.setOrderId("002");
        order2.setSupplierId("2");
        orderTmpDao.insert(order2);
        orderTmpDao.selectByMap(new HashMap<>()).forEach(System.out::println);
    }
}
