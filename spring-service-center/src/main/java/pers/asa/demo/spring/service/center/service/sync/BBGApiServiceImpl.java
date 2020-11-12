package pers.asa.demo.spring.service.center.service.sync;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/31
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/

import org.springframework.stereotype.Service;
import pers.asa.demo.spring.service.center.bean.BBGApiBean;
import pers.asa.demo.spring.service.center.model.SyncDataModel;

@Service
public class BBGApiServiceImpl implements IApiService<BBGApiBean> {
    @Override
    public String platForm() {
        return "BBG";
    }

    @Override
    public void sync(SyncDataModel syncData) {

    }

    @Override
    public BBGApiBean getData(String jsonData) {
        return null;
    }
}
