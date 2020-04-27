package com.asa.demo.springbootconfiguration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author rongbin.xie
 */
@SpringBootApplication
public class SpringBootConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigurationApplication.class, args);
    }

    @Component
    @EnableConfigurationProperties
    @ConfigurationProperties(prefix = "self.params")
    @Setter
    @Getter
    public static class SelfConfigProperties {
        @Value("{servlet.port}")
        private String port;
        private String defaultUrl;
        private Map<String, String> biz;
        private List<Integer> companyIds;
    }
}
