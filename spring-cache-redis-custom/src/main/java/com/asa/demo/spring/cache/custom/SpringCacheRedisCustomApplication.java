package com.asa.demo.spring.cache.custom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

/**
 * @author rongbin.xie
 */
@SpringBootApplication(exclude = RedisAutoConfiguration.class)
public class SpringCacheRedisCustomApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCacheRedisCustomApplication.class);
    }
}

