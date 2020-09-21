package com.asa.demo.spring.webservice.productor.config;

import com.asa.demo.spring.webservice.productor.bean.WSConstant;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import javax.servlet.http.HttpServlet;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/9/17
 * @description <p>@EnableWs enables SOAP Web Service features in this Spring Boot application</p>
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    /**
     * 定义wsdl的路径
     *
     * @param applicationContext app上下文
     * @return wsdl的访问路径
     */
    @Bean
    public ServletRegistrationBean<HttpServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    /**
     * 定义xsd schema的文件资源
     *
     * @return schema类
     */
    @Bean
    public XsdSchema countriesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
    }

    /**
     * 定义对外开放的countriesSchema
     *
     * @param countriesSchema 自定义的schema wsdl
     * @return wsdl的顶一个
     */
    @Bean(name = "countries")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CountriesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace(WSConstant.TARGET_NAME_SPACE);
        wsdl11Definition.setSchema(countriesSchema);
        return wsdl11Definition;
    }
}


