/**
 * @author: asx
 * @date: 2022/10/7
 * @descrition:
 */
package com.asa.demo.dynamic.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.asa.demo.dynamic.datasource.mapper")
public class DynamicDatasourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceApplication.class, args);
    }
}