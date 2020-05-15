package com.asa.demo.spring.cache.custom.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * The configuration is quite simple. First, using the Jedis client, we're defining a connectionFactory.
 * <p>
 * Then, we defined a RedisTemplate using the jedisConnectionFactory.
 * This can be used for querying data with a custom repository.
 */
@Configuration
@EnableCaching
public class DiConfiguration {
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}
