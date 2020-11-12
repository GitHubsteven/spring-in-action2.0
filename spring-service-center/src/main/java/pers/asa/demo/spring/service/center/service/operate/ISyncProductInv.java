package pers.asa.demo.spring.service.center.service.operate;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/2
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface ISyncProductInv<T> {
    /**
     * 同步库存
     *
     * @param model 库存信息
     */
    void syncProductInv(T model);
}
