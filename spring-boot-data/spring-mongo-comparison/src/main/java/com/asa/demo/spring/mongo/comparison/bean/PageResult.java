package com.asa.demo.spring.mongo.comparison.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/16
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
public class PageResult<T> {
    private List<T> records;
    private long total;

    public PageResult(List<T> records, long total) {
        this.records = records;
        this.total = total;
    }
}
