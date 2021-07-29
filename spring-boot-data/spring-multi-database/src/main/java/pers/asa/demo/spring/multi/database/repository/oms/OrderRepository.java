package pers.asa.demo.spring.multi.database.repository.oms;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.asa.demo.spring.multi.database.model.oms.TradeModel;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/29 12:12
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/29 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface OrderRepository extends JpaRepository<TradeModel, Integer> {
}
