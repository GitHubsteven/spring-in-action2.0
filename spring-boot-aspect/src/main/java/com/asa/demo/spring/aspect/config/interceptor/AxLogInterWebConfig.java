package com.asa.demo.spring.aspect.config.interceptor;

import com.asa.demo.spring.aspect.handler.LogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: rongbin.xie
 * @email: xierongbin@chinalife-p.com.cn
 * @date: 2024/6/27
 * @description:
 */
@Configuration
public class AxLogInterWebConfig extends WebMvcConfigurationSupport {
    @Bean
    LogInterceptor logInterceptor() {
        return new LogInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor());
    }
}
