package com.asa.demo.mybatis.mysql.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/23
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
public class OrderTmpModel {
    private Integer id;
    private String supplierId;
    private String batchId;
    private String orderId;
}
