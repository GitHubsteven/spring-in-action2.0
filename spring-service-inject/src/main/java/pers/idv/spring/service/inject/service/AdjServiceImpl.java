package pers.idv.spring.service.inject.service;

import org.springframework.stereotype.Service;
import pers.idv.spring.service.inject.demo.AdjBean;

/**
 * @version 1.0.0
 * @author: rongbin.xie
 * @date: 2020/4/26
 * @description:
 * @copyright: COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class AdjServiceImpl implements IService<AdjBean> {
    @Override
    public AdjBean demo() {
        return new AdjBean("dep-adj", "id-ad123");
    }
}
