package com.asa.dem.spring.boot.vwe.model;

import com.asa.dem.spring.boot.common.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/23
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
@ToString
public class OrderTmp extends BaseModel<Integer> {
    private String supplierId;
    private String batchId;
    private String orderId;
}
