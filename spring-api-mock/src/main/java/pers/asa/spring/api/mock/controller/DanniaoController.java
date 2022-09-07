package pers.asa.spring.api.mock.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.asa.spring.api.mock.bean.BaseDanniaoResponse;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/7/14
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController()
@RequestMapping("/api/mock")
public class DanniaoController {
    @PostMapping("/ediReceive/ediStandardReceive/api")
    public BaseDanniaoResponse ediStandardReceive(@RequestParam("logistic_provider_id") String logisticProviderId,
                                                  @RequestParam("data_digest") String dataDigest,
                                                  @RequestParam("logistics_interface") String logisticsInterface) {
        BaseDanniaoResponse response = new BaseDanniaoResponse();
        response.setSuccess(true);
        response.setErrorCode("0");
        response.setErrorMsg("logistic_provider_id->" + logisticProviderId + " ,data_digest->"
                + dataDigest + " ,logistics_interface->" + logisticsInterface);
        return response;
    }
}
