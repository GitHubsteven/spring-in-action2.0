| 目的      | 工具            | 
|---------|---------------|
| 连接池管理   | HikariCP      | 
| ORM     | JPA           | 
| ORM API | Sharding-jdbc | 

#### 如何动态的确定datasource
```java
    private DataSource buildDataSource() throws SQLException {
        //设置从库数据源集合
        Map<String, DataSource> slaveDataSourceMap = new HashMap<>();
        slaveDataSourceMap.put(database1Config.getDatabaseName(), database1Config.createDataSource());
        slaveDataSourceMap.put(database2Config.getDatabaseName(), database2Config.createDataSource());

        //获取数据源对象
        return MasterSlaveDataSourceFactory.createDataSource("masterSlave", database0Config.getDatabaseName(),
        database0Config.createDataSource(), slaveDataSourceMap, MasterSlaveLoadBalanceStrategyType.getDefaultStrategyType());
    }
```
通过MasterSlaveDataSourceFactory.createDataSource来生成类似于AbstractRoutingDataSource类的实现子类

#### 如何判断sql类型进行访问哪个数据的判断呢？





#### 参考文章：
[SpringBoot使用Sharding-JDBC读写分离](https://www.jianshu.com/p/94b2c2f58302)

