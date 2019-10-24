package pers.demo.asa.spring.data.mybatis.plus.mysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 14:22 2019/10/24.
 */
@SpringBootApplication
@MapperScan("pers.demo.asa.spring.data.mybatis.plus.mysql.mapper")
public class MybatisPlusMysqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusMysqlApplication.class, args);
    }
}