##### 创建一个测试SpringCache的demo
参考文献: 
1. [A Guide To Caching in Spring](https://www.baeldung.com/spring-cache-tutorial)
2. [Caching Data with Spring](https://spring.io/guides/gs/caching/)

第一个没有具体的case或者体现的例子，但是有具体的使用和声明说明。这里实现两个例子，第一个是基于文档1的
参考单元测试AddressServiceTest.

第二个case是参考文档2的，这里有具体的例子，很详细，但是通过application来测试并不是那么通用，一般我们
是使用单元测试来测试的。

总结下使用步骤，总共有两种方式，这里也是文档1和2的不同

##### 方式一 spring mvc
1. component CacheManger,这里的意思是需要创建一个cache的管理类，代码如下：
```
@Configuration
@EnableCaching
public class CachingConfig {
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("directory"),
                new ConcurrentMapCache("books"),
                new ConcurrentMapCache("address")));
        return cacheManager;
    }
}
```
这表明这个是用于当前中的cache的管理类，定义了不同key对应的不同的cache管理，spring在缓存的时候根据
value来获取cache管理器，一般value为CachingConfig中定义了的值，如"books","address"，否则会报错。

2. 在component的public方法，最好是获取bean/model数据可复用的pojo中声明Cachable，代码如下：
```
@Service
public class AddressService extends BaseService {

    private final AtomicInteger count = new AtomicInteger(1);

    @Cacheable(value = "address", key = "#customer.name")
    public String getAddress(Customer customer) {
        logger.info("enter the get address method ...");
        String time = String.format("%d", new Date().getTime());
        return customer.getAddress() + time.substring(time.length() - 8) + "c" + count.getAndIncrement();
    }

}
```
通常来说，这样就可以了，然后在单元测试类中，调用方法，你会发现在相同name（key)的函数调用下除第一次后面都不会执行函数，而是从缓存中获取数据。
结果如下：
```
2019-08-27 19:10:50.448  INFO 26408 --- [           main] c.asa.demo.spring.cache.comon.Loggable   : enter the get address method ...
name: 0 ganzhou04250449c1
2019-08-27 19:10:50.450  INFO 26408 --- [           main] c.asa.demo.spring.cache.comon.Loggable   : enter the get address method ...
name: 1 ganzhou04250450c2
name: 0 ganzhou04250449c1   //这里不用调用函数了
name: 1 ganzhou04250450c2   //这里不用调用函数了
```

##### 方式二 在spring Boot下

参考文档2，在spring boot下，我们可以更加简单的使用SpringCache。
1. 我们更换上面的第一步，直接在application中声明为，@EnableCaching，代码如下：
```
@SpringBootApplication
@EnableCaching
public class SpringCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCacheApplication.class, args);
    }
}
```

2. 我们注释了方式一种的configuration（这里是为了避免重复注入），代码如下：
```
//@Configuration
//@EnableCaching
public class CachingConfig {
    //    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("directory"),
                new ConcurrentMapCache("books"),
                new ConcurrentMapCache("address")));
        return cacheManager;
    }
}
```
重新执行测试类，得到相同的结果，在这里spring boot环境下，Application被声明为@EnableCaching的话，
那么每次扫描到  @Cacheable("xxxx")的时候，会自动的生成一个对应的cache管理器，就不用自己手动声明了，
更加方便快捷。
