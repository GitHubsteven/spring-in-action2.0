#### 基于Spring Boot消费一个Webservice

参考文档：
[基于Spring Boot创建一个Webservice]()

项目代码参考：
[web-service-consumer](https://github.com/GitHubsteven/spring-in-action2.0/tree/master/spring-boot-webservice/web-service-consumer)

已知一个soap的webService，通过api去调用web service服务。
1. wsdl

##### 根据wsdl来生成对应的java bean
1. 使用插件org.codehaus.mojo.jaxb2-maven-plugin，在pom.xml中引入插件，代码如下：
    ```
     <plugins>
            <plugin>
                <groupId>org.jvnet.jaxb2.maven2</groupId>
                <artifactId>maven-jaxb2-plugin</artifactId>
                <version>0.14.0</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <schemaLanguage>WSDL</schemaLanguage>
                    <generateDirectory>${project.basedir}/src/main/java</generateDirectory>
                    <!--指定生成的schema所在的包-->
                    <generatePackage>com.asa.demo.spring.webservice.consumer.wsdl</generatePackage>
                    <schemas>
                        <schema>
                            <!--设置wsdl schema的url-->
                            <url>http://localhost:9200/ws/countries.wsdl</url>
                        </schema>
                    </schemas>
                </configuration>
            </plugin>
            <!-- end::wsdl[] -->
        </plugins>
    ```
compile 模块，生成java bean.

**可能遇到的问题**
1. 生成的bean可能不是目的类型，如String，而是JabxElement<String>，这个时候可以在resources中加入文件jaxb-bingding.xjb，那么文件目录如下：
```
----                -------------     ------ ----
-a---         2020/9/17     13:31          1 application.properties
-a---         2020/9/18     13:37        215 jaxb-bindings.xjb
```

jaxb-bindings.xjb的代码如下：
```
<jaxb:bindings version="2.0"
               xmlns:jaxb="http://java.sun.com/xml/ns/jaxb">
    <jaxb:bindings>
        <jaxb:globalBindings generateElementProperty="false"/>
    </jaxb:bindings>
</jaxb:bindings>
```

application.properties中可以没有任何配置，如果没有需求的话。

在pom.xml的maven-jaxb2-plugin中增加代码：
```
<!--</schemas>-->
<bindings>
    <binding>
        <fileset>
            <!-- Defaults to bindingDirectory. -->
            <directory>${basedir}/src/main/resources</directory>
            <!-- Defaults to bindingIncludes. -->
            <includes>
                <include>*.xjb</include>
            </includes>
        </fileset>
    </binding>
</bindings>
```

##### 生成client

为了可以通过soap来消费webservice 端口，我们需要使用导入依赖：
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web-services</artifactId>
	<exclusions>
		<exclusion>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
		</exclusion>
	</exclusions>
</dependency>
```

client命名为CountryClient，代码如下：
```
public class CountryClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(CountryClient.class);
    // 定义服务器地址和路径
    private static final String HOST = "http://localhost:9200/ws/countries";

    public GetCountryResponse getCountry(String country) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        log.info("Requesting location for " + country);

        return (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(HOST, request,
                new SoapActionCallback("http://example.com/learningwebservice/GetCountryRequest"));
    }
}
```

不通过spring，直接手动生成bean来运行的方式，NoInjectRunner 代码如下：
```
public class NoInjectRunner {
    public static void main(String[] args) {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.asa.demo.spring.webservice.consumer.wsdl");

        CountryClient client = new CountryClient();
        client.setDefaultUri("http://localhost:9200/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        Stream.of("Spain", "Poland").forEach(country -> {
            System.out.println(client.getCountry(country).getCountry().getCurrency());
        });

    }
}

```

为了支持Spring的注入方式，我们需要一些配置，创建/config/CountryConfiguration，代码如下：
```
@Configuration
public class CountryConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.asa.demo.spring.webservice.consumer.wsdl");
        return marshaller;
    }

    @Bean
    public CountryClient countryClient(Jaxb2Marshaller marshaller) {
        CountryClient client = new CountryClient();
        client.setDefaultUri("http://localhost:9200/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
```

测试类代码如下：
```
@SpringBootTest
@RunWith(SpringRunner.class)
public class CountryClientTest {
    @Autowired
    private CountryClient countryClient;

    @Test
    public void testGetCountry() {
        GetCountryResponse spain = countryClient.getCountry("Spain");
        System.out.println(spain.getCountry().getCurrency());
    }
}
```
源文件[CountryClientTest.java](https://github.com/GitHubsteven/spring-in-action2.0/blob/master/spring-boot-webservice/web-service-consumer/src/test/java/com/asa/demo/spring/webservice/consumer/client/CountryClientTest.java)