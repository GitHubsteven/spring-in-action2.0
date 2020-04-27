package pers.idv.spring.service.inject.service;

import pers.idv.spring.service.inject.demo.DataBean;

/**
 * @version 1.0.0
 * @author: rongbin.xie
 * @date: 2020/4/26
 * @description:
 * @copyright: COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class DataServiceImpl implements IService<DataBean> {
    @Override
    public DataBean demo() {
        return new DataBean("data-name");
    }
}
