#### 参考
1. [simple-use-case-comparison-jvm](https://dzone.com/articles/simple-use-case-comparison-jvm)
2. [getting-started/quick-start](https://mongodb.github.io/mongo-java-driver/3.4/driver/getting-started/quick-start/)
3. [jongo](https://jongo.org/)

#### 比较
比较spring-boot-data-starter-mongo.mongoTemplate和Jongo的时候，我们可以类似于Jpa和mybatis的比较
前者对于CRUD更简单，但是后者有更多的自由。
#### 语法
1.MongoDb 脚本
```
db.friends.find({age: {$gt: 18}})
```
2.Java Driver
```
friends.find(new BasicDBObject("age",new BasicDBObject("$gt",18)))
```
3.jongo
```
friends.find("{age: {$gt: 18}}").as(Friend.class)
```

#### 特征
1. jongo更多数据基于string类型，然而由于jackson的存在，进行映射转化也是非常简单的。
具体的可以参考JongoServiceImpl.java
2. jongo更加手动话，熟悉mongo脚本会对使用更有帮助
