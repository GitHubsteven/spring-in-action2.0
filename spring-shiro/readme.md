#### Shiro
[w3cschool-shiro](https://www.w3cschool.cn/shiro/uxtg1ifx.html)

##### 作用
1. authentication 身份认证
2. authorization 授权
3. session management
4. remember me

##### 角色
1. subject: 登录用户或者任何如此类的事务，如代码，机器人，爬虫或者其他
2. SecurityManager: 安全管理器，安全管理器；即所有与安全有关的操作都会与 SecurityManager 交互；且它管理着所有 Subject；可以看出它是 Shiro 的核心，它负责与后边介绍的其他组件进行交互，如果学习过 SpringMVC，你可以把它看成 DispatcherServlet 前端控制器；
3. Realm: 域，Shiro 从从 Realm 获取安全数据（如用户、角色、权限），就是说 SecurityManager 要验证用户身份，那么它需要从 Realm 获取相应的用户进行比较以确定用户身份是否合法；也需要从 Realm 得到用户相应的角色 / 权限进行验证用户是否能进行操作；
可以把 Realm 看成 DataSource，即安全数据源。

##### 1. shiro 身份验证
**身份验证**
- 身份验证，即在应用中谁能证明他就是他本人。一般提供如他们的身份 ID 一些标识信息来表明他就是他本人，如提供身份证，用户名 / 密码来证明。
- 在 shiro 中，用户需要提供 principals （身份）和 credentials（证明）给 shiro，从而应用能验证用户身份：
- principals：身份，即主体的标识属性，可以是任何东西，如用户名、邮箱等，唯一即可。一个主体可以有多个 principals，但只有一个 Primary principals，一般是用户名 / 密码 / 手机号。
- credentials：证明 / 凭证，即只有主体知道的安全值，如密码 / 数字证书等。
最常见的 principals 和 credentials 组合就是用户名 / 密码了。
另外两个相关的概念是之前提到的 Subject 及 Realm，分别是主体及验证主体的数据源。

参考代码：ShiroTest.java
说明
1. 首先调用 Subject.login(token) 进行登录，其会自动委托给 Security Manager，调用之前必须通过 SecurityUtils.setSecurityManager() 设置；
2. SecurityManager 负责真正的身份验证逻辑；它会委托给 Authenticator 进行身份验证；
3. Authenticator 才是真正的身份验证者，Shiro API 中**核心**的身份认证入口点，此处可以自定义插入自己的实现；
4. Authenticator 可能会委托给相应的 AuthenticationStrategy 进行多 Realm 身份验证，默认 ModularRealmAuthenticator 会调用 AuthenticationStrategy 进行多 Realm 身份验证；
5. Authenticator 会把相应的 token 传入 Realm，从 Realm 获取身份验证信息，
如果没有返回 / 抛出异常表示身份验证失败了。此处可以配置多个 Realm，将按照相应的顺序及策略进行访问。
###### Realm
Realm：域，Shiro 从从 Realm 获取安全数据（如用户、角色、权限），就是说 SecurityManager 要验证用户身份，那么它需要从 Realm 获取相应的用户进
行比较以确定用户身份是否合法；也需要从 Realm 得到用户相应的角色 / 权限进行验证用户是否能进行操作；可以把 Realm 看成 DataSource，即安全数据源。
如我们之前的 ini 配置方式将使用 org.apache.shiro.realm.text.IniRealm。

org.apache.shiro.realm.Realm 接口如下：
```
String getName(); //返回一个唯一的Realm名字
boolean supports(AuthenticationToken token); //判断此Realm是否支持此Token
AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
 throws AuthenticationException;  //根据Token获取认证信息
```
单Realm配置
1. 自定义Realm实现，
```
public class MyRealm1 implements Realm {
    @Override
    public String getName() {
        return "myrealm1";
    }
    @Override
    public boolean supports(AuthenticationToken token) {
        //仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken; 
    }
    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();  //得到用户名
        String password = new String((char[])token.getCredentials()); //得到密码
        if(!"zhang".equals(username)) {
            throw new UnknownAccountException(); //如果用户名错误
        }
        if(!"123".equals(password)) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
```
2. ini 配置文件指定自定义 Realm 实现 (shiro-realm.ini)
```
# 声明一个realm
myRealm1=com.github.zhangkaitao.shiro.chapter2.realm.MyRealm1
# 指定securityManager的realms实现
securityManager.realms=$myRealm1
```
通过 $name 来引入之前的 realm 定义
##### 多Realm配置
1. ini 配置文件
```
# 声明一个realm
myRealm1=com.github.zhangkaitao.shiro.chapter2.realm.MyRealm1
myRealm2=com.github.zhangkaitao.shiro.chapter2.realm.MyRealm2
# 指定securityManager的realms实现
securityManager.realms=$myRealm1,$myRealm2
```