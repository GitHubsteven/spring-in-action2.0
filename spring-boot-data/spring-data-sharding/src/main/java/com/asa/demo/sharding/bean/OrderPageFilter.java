/**
 * @author: asx
 * @date: 2022/10/15
 * @descrition:
 */
package com.asa.demo.sharding.bean;

import com.asa.demo.sharding.domain.BtOrderModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;

import java.util.List;

public class OrderPageFilter implements IPage<BtOrderModel> {
    private List<OrderItem> orderBy;

    private List<BtOrderModel> records;

    private long pages;

    private long size = 1;

    private long total = 0L;

    private long current;

    @Override
    public List<OrderItem> orders() {
        return orderBy;
    }

    @Override
    public List<BtOrderModel> getRecords() {
        return this.records;
    }

    @Override
    public IPage<BtOrderModel> setRecords(List<BtOrderModel> records) {
        this.records = records;
        return this;
    }

    @Override
    public long getTotal() {
        return total;
    }

    @Override
    public IPage<BtOrderModel> setTotal(long total) {
        this.total = total;
        return this;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public IPage<BtOrderModel> setSize(long size) {
        this.size = size;
        return this;
    }

    @Override
    public long getCurrent() {
        return this.current;
    }

    @Override
    public IPage<BtOrderModel> setCurrent(long current) {
        this.current = current;
        return this;
    }

}
