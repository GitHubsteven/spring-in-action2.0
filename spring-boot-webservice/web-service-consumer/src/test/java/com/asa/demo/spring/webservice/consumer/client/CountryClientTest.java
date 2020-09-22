package com.asa.demo.spring.webservice.consumer.client;

import com.asa.demo.spring.webservice.consumer.wsdl.GetCountryResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/9/22
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class CountryClientTest {
    @Autowired
    private CountryClient countryClient;

    @Test
    public void testGetCountry() {
        GetCountryResponse spain = countryClient.getCountry("Spain");
        System.out.println(spain.getCountry().getCurrency());
    }
}
