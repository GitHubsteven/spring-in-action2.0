package pers.asa.demo.spring.service.center.service.sync;

import org.springframework.stereotype.Service;
import pers.asa.demo.spring.service.center.service.operate.IPlatform;
import pers.asa.demo.spring.service.center.service.operate.ISyncProductInv;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/2
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class JdSyncProductInvService implements IPlatform, ISyncProductInv<JdSyncProductInvService.JdSyncProdInvBean> {
    @Override
    public String platform() {
        return "jd";
    }

    @Override
    public void syncProductInv(JdSyncProdInvBean model) {

    }

    static class JdSyncProdInvBean {
    }
}
