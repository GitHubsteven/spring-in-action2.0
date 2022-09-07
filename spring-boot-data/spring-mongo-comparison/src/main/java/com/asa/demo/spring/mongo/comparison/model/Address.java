package com.asa.demo.spring.mongo.comparison.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/16
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
public class Address {
    private String province;
    private String city;
    private String area;
}
