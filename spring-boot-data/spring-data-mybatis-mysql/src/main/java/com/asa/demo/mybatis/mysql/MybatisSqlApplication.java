package com.asa.demo.mybatis.mysql;

import com.asa.demo.mybatis.mysql.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Authoer: asa.x
 * @Date: 2019/10/7
 * @Descrition:
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
