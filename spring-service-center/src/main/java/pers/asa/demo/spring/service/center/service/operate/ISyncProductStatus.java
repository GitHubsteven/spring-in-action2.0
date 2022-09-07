package pers.asa.demo.spring.service.center.service.operate;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/2
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface ISyncProductStatus<T> {
    /**
     * 同步商品状态
     *
     * @param model
     */
    void syncProductStatus(T model);
}
