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

##### 分页
