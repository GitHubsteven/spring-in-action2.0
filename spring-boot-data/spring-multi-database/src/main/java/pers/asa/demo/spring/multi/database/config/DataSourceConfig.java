package pers.asa.demo.spring.multi.database.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/29 11:18
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/29 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
//@Configuration
public class DataSourceConfig {
//    @Bean(name = "accountDS")
//    @Qualifier("accountDS")
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource.account")
//    public DataSource account() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "omsDS")
//    @Qualifier("omsDS")
//    @ConfigurationProperties(prefix = "spring.datasource.oms")
//    public DataSource oms() {
//        return DataSourceBuilder.create().build();
//    }
}

