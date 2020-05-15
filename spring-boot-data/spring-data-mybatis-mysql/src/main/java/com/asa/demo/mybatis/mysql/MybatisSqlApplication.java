package com.asa.demo.mybatis.mysql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: asa.x
 * @date: 2019/10/7
 * @descrition:
 */
@SpringBootApplication
public class MybatisSqlApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MybatisSqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("start mybatis app~~~~~~~~~~");
    }
}
