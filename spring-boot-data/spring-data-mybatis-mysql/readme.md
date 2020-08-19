参考文章：

[基于 SpringBoot2.0+优雅整合 SpringBoot+Mybatis](https://segmentfault.com/a/1190000017211657)

[Mybatis之通用Mapper（基于mybatis的Provider机制无需第三方插件包）](https://blog.csdn.net/mayfly_hml/article/details/88846479)

[如何开发自己的通用Mapper](https://blog.csdn.net/isea533/article/details/41892319)

#### 一些细节
1. 在使用SqlProvider的时候，可以通过option声明定义一些行为，如insert的时候返回id，和id的变化规则，代码case如下：
```
   @InsertProvider(type = InsertSqlProvider.class, method = "sql")
   @Options(useGeneratedKeys = true, keyProperty = "id")
   Integer insert(Entity entity);
```