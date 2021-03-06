package com.asa.demo.spring.cache.conf;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @date: Created at 15:39 2019/8/27.
 */
//@Configuration
//@Cacheable
public class CacheConfig {
    //    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("address");
    }
}