### WebService

项目参考 [web-service-productor](https://github.com/GitHubsteven/spring-in-action2.0/tree/master/spring-boot-webservice/web-service-productor)

#### 参考文档
1. [producing-web-service/](https://spring.io/guides/gs/producing-web-service/)
2. [consuming-web-service](https://spring.io/guides/gs/consuming-web-service/#initial)

#### 什么是WebService？
[What are Web Services?](https://www.tutorialspoint.com/webservices/what_are_web_services.htm)



#### 创建一个WebService
1. 定义.xsd文件，在其中，定义java bean
```
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:tns="http://asa.com/demo/spring/webservice/productor/wsdl"
           targetNamespace="http://asa.com/demo/spring/webservice/productor/wsdl" elementFormDefault="qualified">

    <xs:element name="getCountryRequest">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="name" type="xs:string"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="getCountryResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="country" type="tns:country"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
    ...
    </xs:simpleType>
</xs:schema>
```
利用的插件，在pom.xml文件中：
```
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>jaxb2-maven-plugin</artifactId>
    <version>1.6</version>
    <executions>
        <execution>
            <id>xjc</id>
            <goals>
                <goal>xjc</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <schemaDirectory>${project.basedir}/src/main/resources/</schemaDirectory>
        <outputDirectory>${project.basedir}/src/main/java</outputDirectory>
        <clearOutputDir>false</clearOutputDir>
    </configuration>
</plugin>
```

compile module生成对应的bean，文件目录根据xsd.targetNamespace来生成
```
 targetNamespace="http://asa.com/demo/spring/webservice/productor/wsdl"
```
地址倒置com.asa，路径顺序相加：demo.spring.webservice.productor.wsdl
最终地址为com.asa.demo.spring.webservice.productor.wsdl

ok，bean生成后，我们需要定义repository，来管理数据，这里当然是模拟数据


##### 生成repository

模拟数据，这里的数据自定义

```
@Component
public class CountryRepository {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        // initialize countries map
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);

        countries.put(spain.getName(), spain);

        // add if you want
    }

    public Country findCountry(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return countries.get(name);
    }

    public List<Country> listCountry() {
        return new ArrayList<>(countries.values());
    }
```

##### 定义endpoint

endpoint，类似于controller中的api接口。

0. 为了使用wsdl的服务，我们需要导入依赖：
```
<dependency>
    <groupId>wsdl4j</groupId>
    <artifactId>wsdl4j</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web-services</artifactId>
</dependency>
```
1. 定义命名空间的url，值是先前xsd文件中的targetNameSpace
```
 // http://asa.com/demo/spring/webservice/productor/wsdl
 private static final String NAMESPACE_URI = WSConstant.TARGET_NAME_SPACE;
 ```
2. 定义endpoint，指定接口的localPort，想当于Rest api中的path
```
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }
```
3. 自定义wsdl等相关访问路径
```
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
```

配置项目的端口，启动项目
```
server.port=9200

spring.application.name=WSProductor
```

访问： http://localhost:9200/ws/countries.wsdl
可以获取上面配置的wsdl

发送请求
```
curl --location --request POST 'http://localhost:9200/ws/countries' \
--header 'Content-type: text/xml' \
--data-raw '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:gs="http://asa.com/demo/spring/webservice/productor/wsdl">
    <soapenv:Header/>
    <soapenv:Body>
        <gs:getCountryRequest>
            <gs:name>Spain</gs:name>
        </gs:getCountryRequest>
    </soapenv:Body>
</soapenv:Envelope>'
```
可以获取对应的返回结果：
```
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getCountryResponse xmlns:ns2="http://asa.com/demo/spring/webservice/productor/wsdl">
            <ns2:country>
                <ns2:name>Spain</ns2:name>
                <ns2:population>46704314</ns2:population>
                <ns2:capital>Madrid</ns2:capital>
                <ns2:currency>EUR</ns2:currency>
            </ns2:country>
        </ns2:getCountryResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
