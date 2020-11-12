package pers.asa.demo.spring.service.center.service.sync;

import org.springframework.stereotype.Service;
import pers.asa.demo.spring.service.center.JacksonUtils;
import pers.asa.demo.spring.service.center.bean.AliApiBean;
import pers.asa.demo.spring.service.center.model.SyncDataModel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/31
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class AliApiServiceImpl implements IApiService<AliApiBean> {

    Map<String, Consumer<Map<String, Object>>> apiCenterMap = new ConcurrentHashMap<>();

    {
        apiCenterMap.put("api1", this::api1);
        apiCenterMap.put("api2", this::api2);
    }

    @Override
    public String platForm() {
        return "Ali";
    }


    public void api1(Map<String, Object> params) {
        System.out.println("---->api1 and params: " + JacksonUtils.bean2Map(params));
    }

    public void api2(Map<String, Object> params) {
        System.out.println("---->api2 and params: " + JacksonUtils.bean2Map(params));
    }

    @Override
    public void sync(SyncDataModel syncData) {
        AliApiBean apiInfo = getData(syncData.getDataJson());
        String syncApi = apiInfo.getSyncApi();
//        Consumer<Map<String, Object>> apiConsumer = apiCenterMap.get(syncApi);
//        if (apiConsumer == null) {
//            throw new RuntimeException();
//        }
        Map<String, Object> params = new HashMap<>();
        params.put("1", "a");
        params.put("2", "b");
//        apiConsumer.accept(params);
        try {
            Method method = this.getClass().getDeclaredMethod(syncApi, Map.class);
            method.invoke(this, params);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AliApiBean getData(String jsonData) {
        return JacksonUtils.json2Bean(jsonData, AliApiBean.class);
    }
}
