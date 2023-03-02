#### 参考文档
1. https://blog.csdn.net/qq_35387940/article/details/100514134

#### 消费的方式
1. config/MessageListenerConfig + MyAckMessageReceiver统一规划消费
2. 在method1中，直接在component类上面声明@Component +@RabbitListener
3. 在method3中，@RabbitListener 注释在方法中 + @Service的服务类中，方法可以灵活implement MessageListen的类或者子类


#### todo
1. 为什么会有个SimpleMessageListenerContainer，这个模式是spring的模式吗？jdbc好像也是常见
2. 如何配置每个队列的消费者的数量，比如配置为N,而不是默认的1