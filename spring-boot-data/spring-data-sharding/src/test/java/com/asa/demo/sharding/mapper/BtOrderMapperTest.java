package com.asa.demo.sharding.mapper;

import com.asa.demo.sharding.ShardingAppTest;
import com.asa.demo.sharding.bean.OrderPageFilter;
import com.asa.demo.sharding.domain.BtOrderItemModel;
import com.asa.demo.sharding.domain.BtOrderModel;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.Assert;
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
        for (int i = 14; i < 24; i++) {
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

    @Test
    public void testSelectPage() {
        OrderPageFilter filter = new OrderPageFilter();
        filter.setSize(10L);
        filter.setCurrent(2L);
        BtOrderModel conditions = new BtOrderModel();
        conditions.setCreateName("asx");
        IPage<BtOrderModel> pageResult = btOrderMapper.selectPage(filter, new Wrapper<BtOrderModel>() {
            @Override
            public BtOrderModel getEntity() {
                return conditions;
            }

            @Override
            public MergeSegments getExpression() {
                return null;
            }

            @Override
            public void clear() {

            }

            @Override
            public String getSqlSegment() {
                return null;
            }
        });
        Assert.assertEquals("count should be 11", 11L, pageResult.getTotal());
        Assert.assertEquals("size should be 1", 1L, pageResult.getRecords().size());
    }

    @Test
    public void selectByOrderNo() {
        BtOrderModel btOrderModel = btOrderMapper.selectById(1581186010371801089L);
        Assert.assertEquals("create should be asx", btOrderModel.getCreateName(), "asx");
    }

    @Test
    public void selectByPage() {
        OrderPageFilter filter = new OrderPageFilter();
        filter.setSize(10L);
        filter.setCurrent(1L);
        BtOrderModel conditions = new BtOrderModel();
        conditions.setCreateName("asx");
    }
}