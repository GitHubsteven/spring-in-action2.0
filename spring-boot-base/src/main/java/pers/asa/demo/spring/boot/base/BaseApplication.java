package pers.asa.demo.spring.boot.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pers.asa.demo.spring.boot.base.annotation.EnableAsaClients;
import pers.asa.demo.spring.boot.base.clients.UniqueClient;
import pers.asa.demo.spring.boot.base.register.TestRegistrar;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/4/28 10:48
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/4/28 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@SpringBootApplication
@EnableAsaClients(clients = {UniqueClient.class}, basePackages = {"pers.asa.demo.spring.boot.base.clients"})
@Import(TestRegistrar.class)
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);

    }
}

