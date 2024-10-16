package com.asa.demo.spring.aspect.config.interceptor;

import com.asa.demo.spring.aspect.handler.AccessInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author: rongbin.xie
 * @email: xierongbin@chinalife-p.com.cn
 * @date: 2024/6/27
 * @description:
 */
@Configuration
public class AxAccessInterWebConfig extends WebMvcConfigurationSupport {

    @Bean
    AccessInterceptor accessInterceptor() {
        return new AccessInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessInterceptor());
    }
}
