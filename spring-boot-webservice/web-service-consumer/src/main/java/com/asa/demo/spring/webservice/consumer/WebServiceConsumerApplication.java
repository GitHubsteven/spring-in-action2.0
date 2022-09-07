package com.asa.demo.spring.webservice.consumer;

import com.asa.demo.spring.webservice.consumer.client.CountryClient;
import com.asa.demo.spring.webservice.consumer.wsdl.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author rb.x
 */
@SpringBootApplication
public class WebServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceConsumerApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(CountryClient quoteClient) {
        return args -> {
            String country = "Spain";

            if (args.length > 0) {
                country = args[0];
            }
            GetCountryResponse response = quoteClient.getCountry(country);
            System.err.println(response.getCountry().getCurrency());
        };
    }
}
