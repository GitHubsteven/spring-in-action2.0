最基本的生产者和消费者的关系
如果在product生成message的之前，worker/consumer都在线，那么执行轮询策略
1. 1个生成可以对应N个消费者，分配的原则默认为轮询
2. N个生成可以对应N个消费者，分配的原则默认为轮询
否则consumer无法消费

##### 特性
1. 如果consumer消费异常的话，那么message也会被删除，解决方案参考项目readme.md
将消费者的autoAck设置为false
```
  // set auto ack-> false, message will stay if error
    boolean isAutoAck = false;
    channel.basicConsume(QUEUE_NAME, isAutoAck, deliverCallback, consumerTag -> {
    });
```
如果不用Pair Dispatch的话，多个worker/consumer的表现行为会很奇怪！可能会出现无法消费的情形。
