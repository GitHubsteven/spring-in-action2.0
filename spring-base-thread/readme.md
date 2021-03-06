**场景分析：**

对于成员变量来说，多线程仍然是个问题，同时，在spring中，这个问题，可能会更加严重，已知条件：
1. spring bean 容器中是单一模式
    ```
    Q1: 那么是否可以说，在单线程中，所有的service的类是相同的？
    Anwser: 如果是单例的话，那么所有的线程都是一个实例，如果没有意外的话
    ```
2. 推测：在多线程中，spring中引进的service可以保持不同，对于不同的线程来说，这是理所当然的。
    ```
    证明它。
    Anwser:也许是不对的，如果service是定义一种行为，和数据无关，那么对于多线程来说，即使是共享一个实例，那么又有什么关系呢？
    ```
3. ThreadLocal真的可以保证多线程下，成员变量的独一性吗？
  
    场景设计1：一个service， service中有两个成员变量Member{name:string}, ThreadLocal<Member>，
    在请求端发送参数name,后端返回上下文+“name:name”,在service的set和get之间增加Thread.sleep,增加线程的处理时间
    详情请参考HelloController + HelloService.
    测试case: 一次性发送多个请求，看返回的结果name是否和发送的一致。

    场景设计2：线程池 + Class.staticMember1 + 成员变量 的线程安全化。
    涉及到的问题：
    Q1: static线程安全吗？当然不安全，但是threadLocal本质上就是static 实现的
    Q2: 函数行为不需要多线程，但是数据需要

    生产环境实例复原(场景3): 多线程(线程池) + spring service class + 私有成员变量 + 跨方法调用
    分析:
        1. 在多线程中，service是单例的话，那么，私有成员变量肯定是不安全
        2. 在单个线程中，跨方法是共享一个线程的
        3. 私有成员变量是为了方法可以共享一个成员变量
        4. threadLocal目测可以解决这个场景
        总结： 在利用线程池来管理多线程的场景中，虽然跨方法使用私有成员变量会增加影响因素，但是在实际上，方法在一个线程中运行，只要我们能保证线程安全
        ，那么就可以保证数据的安全性了。
        
4. 如果threadLocal 无法保证的话，那么该用什么方式来保证。

##### 基本概念

1. CountDownLatch: 保证让所有子线程执行完毕，再执行主线程
参考文档：[java-countdown-latch](https://www.baeldung.com/java-countdown-latch)
> Naturally “Latch released” will always be the last output – as it's dependant on the CountDownLatch releasing.
  
> Note that if we didn't call await(), we wouldn't be able to guarantee the ordering of the execution of the threads, 
>so the test would randomly fail.

2. block each child thread until all the others have started