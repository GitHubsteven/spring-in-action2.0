##### 问题描述：
@Value("${xxx.xx}")可以注入单个的配置属性，但是如果需要配置map或者list的话，那么好像不怎么行

##### 解决方案
自定义Bean来初始化config值，详情 [参考](https://stackoverflow.com/questions/24917194/spring-boot-inject-map-from-application-yml)

case 代码如下
```java
    @Component
    @EnableConfigurationProperties
    @ConfigurationProperties(prefix = "self.params")
    @Setter
    @Getter
    public class SelfConfigProperties {
        @Value("{servlet.port}")   //自定义声明有更高的优先级
        private String port;
        private String defaultUrl;
        private Map<String, String> biz;
    }
```
