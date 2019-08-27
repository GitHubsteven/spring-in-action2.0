package com.asa.demo.spring.cache.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:02 2019/8/27.
 */
@Setter
@Getter
@Accessors(chain = true)
public class Customer {
    private String name;
    private String address; //province + city + country + area, split by "~~~" like "jiangxi~~~ganzhou~~~yudu~~~gongjiang"

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}