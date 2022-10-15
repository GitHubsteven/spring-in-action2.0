package com.asa.demo.sharding.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author xrb16
 * @TableName t_order_item_0
 */
@Data
@TableName("t_order_item")
public class BtOrderItemModel implements Serializable {

    /**
     *
     */
    @TableId(type = IdType.ID_WORKER)
    private Long orderId;
    /**
     *
     */
    private Long itemId;

    /**
     *
     */
    private String orderNo;

    /**
     *
     */
    private String itemName;

    /**
     *
     */
    private BigDecimal price;

    private static final long serialVersionUID = 1L;
}