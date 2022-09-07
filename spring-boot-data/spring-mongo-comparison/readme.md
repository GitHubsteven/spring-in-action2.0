#### 参考
1. [simple-use-case-comparison-jvm](https://dzone.com/articles/simple-use-case-comparison-jvm)
2. [getting-started/quick-start](https://mongodb.github.io/mongo-java-driver/3.4/driver/getting-started/quick-start/)
3. [jongo](https://jongo.org/)

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
1. java driver

    忽略
2. jongo
    ```
     int skip = pageSize * (curPage - 1);
     MongoCursor<Customer> page = customers.find("{lastName:{$regex: #}}", name)
            .skip(skip)
            .limit(pageSize)
            .as(Customer.class);
    ```
3. morphia
    ```
    datastore.createQuery(Book.class)
                    .field("author")
                    .equal("Tom Kirkman")
                    .order(Sort.descending("isbn"))
                    .asList(new FindOptions().limit(1).skip(2));
    ```
4. spring-data
    ```
     PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Order.asc("firstName")));
            Example<Customer> example = Example.of(new Customer(null, "x"));
            Page<Customer> pageResult = customerRepository.findAll(example, pageRequest);
            for (Customer customer : pageResult.getContent()) {
                System.out.println(customer);
            }
    ```
注意，这里的page参数是从0开始的。

##### 聚合函数
1. java driver

    忽略
2. jongo
   ```
   collection.aggregate("{$project:{sender:1}}")
             .and("{$match:{tags:'read'}}")
             .and("{$limit:10}")
             .as(Email.class);
   ```
3. morphia
    ```
    atastore.createAggregation(Book.class)
                    .group("author", Group.grouping("books", Group.push("title")))
                    .out(Author.class);
    ```
4. spring-data
    ```
       Criteria criteria = Criteria.where("firstName").is("asa");
               Aggregation customerAgg = Aggregation.newAggregation(
                       Aggregation.project("firstName", "lastName", "address"),
                       Aggregation.match(criteria),
       //                Aggregation.unwind("orders"),
       //                Aggregation.group("buyerNick").first("buyerNick").as("buyerNick").first("mobile").as("mobile").
       //                        first("address").as("address").sum("payment").as("totalPayment").sum("num").as("itemNum").count().as("orderNum"),
                       Aggregation.sort(Sort.by(Sort.Order.asc("firstName"))),
                       Aggregation.skip(0),
                       Aggregation.limit(2)
               );
               AggregationResults<Customer> results = mongoTemplate.aggregate(customerAgg, "customer", Customer.class);
               List<Customer> customers = new ArrayList<>();
               Iterator<Customer> iterator = results.iterator();
               while (iterator.hasNext()) {
                   customers.add(iterator.next());
               }
    ```

##### 内嵌和引用
1. java driver
2. jongo
    可能查找方式有问题，没有找到直接设置Reference和embeded的声明，embeded直接保存就好，但是reference就只能手动设置id了，
    查询不能直接查询应用或者说需要先查出refId，才能超找出reference。个人觉得不应该是这样的，应该是研究的不够深的原因吧
3. morphia
    1. 	声明属性字段为@Embedded或者@Reference
    ```
       @Embedded
       private Publisher publisher;
       
       @Reference
       private List<Book> companionBooks;
    ```
    2. 在数据库中的json数据结构如图所示
    ```
   {
    // 其他属性
   	"price" : 3.95,
   	"publisher" : {
   		"_id" : ObjectId("5f892eeb6ba6c825f81e7a33"),
   		"name" : "Awsome Publisher"
   	},
   	"companionBooks" : [
   		DBRef("Books", "9789332575103")
   	]
   }
    ```
4. spring-data
    和jongo没啥不一样（目测的认知中是的）


#### 特征
1. jongo更多数据基于string类型，然而由于jackson的存在，进行映射转化也是非常简单的。
具体的可以参考JongoServiceImpl.java
2. jongo更加手动话，熟悉mongo脚本会对使用更有帮助
3. Morphia
    1. 如果不是基于spring架构的话，那么morphia会是一个选择(?)
        >It can be an alternative to SpringData if you're not using the Spring Framework to interact with MongoDB.
    2. 需要指定model所在的包名
        ```
         Morphia morphia = new Morphia();
         morphia.mapPackage("com.asa.demo.spring.mongo.comparison.model");
        ```

#### 比较
比较spring-boot-data-starter-mongo.mongoTemplate和Jongo的时候，我们可以类似于Jpa和mybatis的比较
前者对于CRUD更简单，但是后者有更多的自由。