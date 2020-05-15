package com.asa.demo.spring.cache.conf;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;

import java.util.Arrays;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @date: Created at 17:10 2019/8/27.
 */
//@Configuration
//@EnableCaching
public class CachingConfig {
    //    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("directory"),
                new ConcurrentMapCache("books"),
                new ConcurrentMapCache("address")));
        return cacheManager;
    }
}