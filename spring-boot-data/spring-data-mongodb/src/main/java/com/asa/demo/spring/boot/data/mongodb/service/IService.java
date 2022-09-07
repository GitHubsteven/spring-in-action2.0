package com.asa.demo.spring.boot.data.mongodb.service;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/8/19
 * @description 服务的基本行为定义service
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface IService<M, D> {

    /**
     * 保存
     *
     * @param model 基本信息
     */
    void save(M model);
}
