package pers.asa.demo.spring.service.center.service.sync;

import pers.asa.demo.spring.service.center.bean.BaseApiBean;
import pers.asa.demo.spring.service.center.model.SyncDataModel;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/31
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface IApiService<T extends BaseApiBean> {

    /**
     * 支持的平台
     *
     * @return 支持的平台
     */
    String platForm();


    /**
     * @param syncData 同步数据
     */
    void sync(SyncDataModel syncData);

    T getData(String jsonData);
}
