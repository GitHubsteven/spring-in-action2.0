package com.asa.demo.sharding.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xrb16
 * @TableName t_order_0
 */
@Data
@TableName("t_order")
public class BtOrderModel implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.ID_WORKER)
    private Long orderId;

    /**
     *
     */
    private String orderNo;

    /**
     *
     */
    private String createName;

    /**
     *
     */
    private BigDecimal price;

    private static final long serialVersionUID = 1L;
}