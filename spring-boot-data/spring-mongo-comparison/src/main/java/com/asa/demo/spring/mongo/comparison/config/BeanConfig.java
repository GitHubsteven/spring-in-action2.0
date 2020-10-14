package com.asa.demo.spring.mongo.comparison.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/14
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Configuration
public class BeanConfig {
    @Bean
    public static MongoClient getMongoClient() {
        MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
        return new MongoClient(connectionString);
    }


    @Bean
    public static MongoDatabase getDatabase(MongoClient client) {
        return client.getDatabase("spring-data");
    }
}
