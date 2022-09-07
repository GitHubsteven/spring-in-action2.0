package pers.asa.demo.spring.mvc.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/18
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@SpringBootApplication
@EnableAsync
public class SpringMvcExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMvcExampleApplication.class, args);
    }
}
