推荐阅读：[补习系列-springboot 实现拦截的五种姿势](https://juejin.im/entry/5b7bcdb051882542e82197be)

#### 切面和Filter
这里用来测试spring boot下的切面开发和web filter的案例 

##### Web Filter
自定义WebFilter
只需要继承javax.servlet.filter，然后声明为@Component,然后实现逻辑代码就好了，Case参考
com.asa.demo.spring.aspect.config.filter.UserContextFilter

##### Aspect