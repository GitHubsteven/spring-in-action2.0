# spring cache redis
References:
1. [spring-data-redis-tutorial](https://www.baeldung.com/spring-data-redis-tutorial)
2. [spring-boot-redis-cache](https://www.journaldev.com/18141/spring-boot-redis-cache)

#### 项目构建过程
1. 导入spring-data-redis 抽象类
```xml
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-redis</artifactId>
    <version>2.0.3.RELEASE</version>
 </dependency>
```
2. 导入1的简单实现：jedis
```xml
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>2.9.0</version>
    <type>jar</type>
</dependency>
```
3. 建立一个jedis的链接类
```
@Bean
JedisConnectionFactory jedisConnectionFactory() {
    return new JedisConnectionFactory();
}
```
4. 建立一个数据连接的Template类用来做基础的操作
```
@Bean
public RedisTemplate<String, Object> redisTemplate() {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(jedisConnectionFactory());
    return template;
}
```
5. 在初始化连接工厂的时候，设置信息，当然如果可以的话
```
@Bean
JedisConnectionFactory jedisConnectionFactory() {
    JedisConnectionFactory jedisConFactory
      = new JedisConnectionFactory();
    jedisConFactory.setHostName("localhost");
    jedisConFactory.setPort(6379);
    return jedisConFactory;
}
```


