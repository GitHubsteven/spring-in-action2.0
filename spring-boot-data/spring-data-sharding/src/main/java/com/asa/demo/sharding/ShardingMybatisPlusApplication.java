/**
 * @author: asx
 * @date: 2022/9/17
 * @descrition:
 */
package com.asa.demo.sharding;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.asa.demo.sharding.mapper")
public class ShardingMybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingMybatisPlusApplication.class, args);
    }
}
