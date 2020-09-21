package com.asa.demo.spring.webservice.productor.endpoint;

import com.asa.demo.spring.webservice.productor.bean.WSConstant;
import com.asa.demo.spring.webservice.productor.repository.CountryRepository;
import com.asa.demo.spring.webservice.productor.wsdl.GetCountryRequest;
import com.asa.demo.spring.webservice.productor.wsdl.GetCountryResponse;
import com.asa.demo.spring.webservice.productor.wsdl.ListCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/9/17
 * @description <p>@Endpoint – registers the class with Spring WS as a Web Service Endpoint </p>
 * <p>@PayloadRoot – defines the handler method according to the namespace and localPart attributes</p>
 * <p>@ResponsePayload – indicates that this method returns a value to be mapped to the response payload</p>
 * <p>@RequestPayload – indicates that this method accepts a parameter to be mapped from the incoming request</p>
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Endpoint("/countries")
public class CountryEndpoint {

    private static final String NAMESPACE_URI = WSConstant.TARGET_NAME_SPACE;

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "listCountryRequest")
    @ResponsePayload
    public ListCountryResponse listAll() {
        ListCountryResponse response = new ListCountryResponse();
        response.getCountries().addAll(countryRepository.listCountry());
        return response;
    }
}
