##### 作用
1. 实现spring boot连接mysql
2. 实现spring boot连接mongodb
3. spring boot连接redis参考spring-cache-redis

#### 比较
| 属性   |  redis          |  mysql | mongodb | h2|
|----------|:-------------:|------:| ------:| ------:|
| springBoot抽象依赖 |  .spring-data-redis | spring-boot-starter-data-jpa | spring-boot-starter-data-mongodb | spring-boot-starter-data-jpa|
| 依赖实现 |   redis.clients.jedis  |   mysql.mysqlmysql-connector-java | spring-boot-starter-data-mongodb | com.h2database.h2|
