package pers.asa.demo.spring.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/24
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    /**
     * After defining the Docket bean, its select() method returns an instance of ApiSelectorBuilder,
     * which provides a way to control the endpoints exposed by Swagger.
     * <p>
     * We can configure predicates for selecting RequestHandlers with the help of RequestHandlerSelectors and PathSelectors.
     * Using any() for both will make documentation for our entire API available through Swagger.
     *
     * @return Docket
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("public-api")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
