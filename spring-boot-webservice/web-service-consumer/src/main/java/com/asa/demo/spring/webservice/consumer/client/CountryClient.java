package com.asa.demo.spring.webservice.consumer.client;


import com.asa.demo.spring.webservice.consumer.wsdl.GetCountryRequest;
import com.asa.demo.spring.webservice.consumer.wsdl.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/9/17
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class CountryClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(CountryClient.class);
    // 定义服务器地址和路径
    private static final String HOST = "http://localhost:9200/ws/countries";

    public GetCountryResponse getCountry(String country) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        log.info("Requesting location for " + country);

        return (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(HOST, request,
                new SoapActionCallback("http://example.com/learningwebservice/GetCountryRequest"));
    }
}
