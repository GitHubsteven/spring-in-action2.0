package pers.asa.demo.spring.service.center.service;

import org.springframework.stereotype.Service;
import pers.asa.demo.spring.service.center.JacksonUtils;
import pers.asa.demo.spring.service.center.bean.AliApiBean;
import pers.asa.demo.spring.service.center.model.SyncDataModel;
import pers.asa.demo.spring.service.center.service.sync.IApiService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/31
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class SyncTaskService {

    private final Map<String, IApiService<?>> serviceCenter = new HashMap<>();


    SyncTaskService(Map<String, IApiService<?>> serviceMap) {
        for (IApiService<?> it : serviceMap.values()) {
            serviceCenter.put(it.platForm(), it);
        }
    }

    public void doSync() {
        List<SyncDataModel> syncDataModels = getSyncData();
        for (SyncDataModel syncData : syncDataModels) {
            IApiService<?> iApiService = serviceCenter.get(syncData.getPlatform());
            iApiService.sync(syncData);
        }
    }

    List<SyncDataModel> getSyncData() {
        ArrayList<SyncDataModel> syncDataModels = new ArrayList<>(10);
        SyncDataModel dataModel = new SyncDataModel();
        dataModel.setPlatform("Ali");
        dataModel.setSyncMethod("api1");
        AliApiBean aliApiBean = new AliApiBean();
        aliApiBean.setSyncApi("api1");
        dataModel.setDataJson(JacksonUtils.toJson(aliApiBean));
        syncDataModels.add(dataModel);
        return syncDataModels;
    }

}
