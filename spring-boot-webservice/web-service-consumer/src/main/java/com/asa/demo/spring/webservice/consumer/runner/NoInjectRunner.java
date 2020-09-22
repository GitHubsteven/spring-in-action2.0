package com.asa.demo.spring.webservice.consumer.runner;

import com.asa.demo.spring.webservice.consumer.client.CountryClient;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.stream.Stream;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/9/22
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class NoInjectRunner {
    public static void main(String[] args) {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.asa.demo.spring.webservice.consumer.wsdl");

        CountryClient client = new CountryClient();
        client.setDefaultUri("http://localhost:9200/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        Stream.of("Spain", "Poland").forEach(country -> {
            System.out.println(client.getCountry(country).getCountry().getCurrency());
        });

    }
}
