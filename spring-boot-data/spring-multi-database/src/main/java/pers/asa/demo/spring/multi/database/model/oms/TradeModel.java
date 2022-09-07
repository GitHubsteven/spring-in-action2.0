package pers.asa.demo.spring.multi.database.model.oms;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/29 11:34
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/29 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Entity
@Table(schema = "oms", name = "trade")
@Setter
@Getter
public class TradeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, name = "order_id")
    private String orderId;

    private BigDecimal amount;
}

