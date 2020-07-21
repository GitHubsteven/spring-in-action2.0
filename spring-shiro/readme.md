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

