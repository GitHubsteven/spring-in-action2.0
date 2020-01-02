参考文档： [rest-architectural-constraints](https://restfulapi.net/rest-architectural-constraints/)

>REST stands for Representational State Transfer, a term coined by Roy Fielding in 2000. It is an architecture style for designing loosely coupled applications over HTTP, that is often used in the development of web services. REST does not enforce any rule regarding how it should be implemented at lower level, it just put high level design guidelines and leave you to think of your own implementation.

REST表示“表现的状态转移”，一个由Roy Fielding在2000年提出来的概念。它是一种给基于HTTP上的应用的松耦的的设计架构风格，并且常应用于web服务的开发。REST不会规定底层是如何实现的，它只会在高级层上指导你如何思考自己的实现。

##### Architectural Constraints
>REST defines 6 architectural constraints which make any web service – a true RESTful API.

REST 定义了6个架构限制去保证你web服务成为一个正真的RESTful API

1. Uniform interface
2. Client–server
3. Stateless
4. Cacheable
5. Layered system
6. Code on demand (optional)

**Uniform interface**
>As the constraint name itself applies, you MUST decide APIs interface for resources inside the system which are exposed to API consumers and follow religiously. A resource in the system should have only one logical URI, and that should provide a way to fetch related or additional data. It’s always better to synonymize a resource with a web page.

正如名字所示，你必须为将要暴露给API的使用者和跟随者的资源定义好APIs接口。系统中的一个资源必须只有一个逻辑URI，并且通过它可以获取相关或者其他的数据。最好将资源理解为网页。
>Any single resource should not be too large and contain each and everything in its representation. Whenever relevant, a resource should contain links (HATEOAS) pointing to relative URIs to fetch related information.

一个单独的资源应当不会太大，重复和应当包含所有的表现的东西。无论何时，一个资源都应当包含指向那些可以获取相关信息的链接（HATEOAS)。
>Also, the resource representations across the system should follow specific guidelines such as naming conventions, link formats, or data format (XML or/and JSON).

另外，在整个系统中，资源表示必须遵循一些规则，如命名规则，链接格式或者数据格式（json/xml等）
>All resources should be accessible through a common approach such as HTTP GET and similarly modified using a consistent approach.

所有的资源应当可以通过一个公共的方法来获取，如HTTP GET，类似的，也可以通过一致的方法来改变。

>>Once a developer becomes familiar with one of your APIs, he should be able to follow similar approach for other APIs.

>一旦开发员熟悉了你的APIs的话，那么他也可以根据类似的方法知道其他APIs

**Client–server**
>This essentially means that client application and server application MUST be able to evolve separately without any dependency on each other. A client should know only resource URIs, and that’s all. Today, this is normal practice in web development, so nothing fancy is required from your side. Keep it simple.

这指的是客户端应用和服务端应用必须可以相互独立的开发，两者之间没有任何依赖。客户端所需要知道的仅仅是URIs而已。在今天，这正常不过了，所以，对你来说也没啥好说的。保持简单。

>>Servers and clients may also be replaced and developed independently, as long as the interface between them is not altered.

>服务器和客户端也可以独立替换和开发，只要它们之间的接口不变即可。

**Stateless**
>Roy fielding got inspiration from HTTP, so it reflects in this constraint. Make all client-server interactions stateless. The server will not store anything about the latest HTTP request the client made. It will treat every request as new. No session, no history.

Roy fielding 从HTTP获得灵感，并且表现在这里。让所有的客户端-服务端交互都是无状态的。服务端不会保存客户端的任何东西，它对待任何请求都是新的，没有会话，没有历史。
>If the client application needs to be a stateful application for the end-user, where user logs in once and do other authorized operations after that, then each request from the client should contain all the information necessary to service the request – including authentication and authorization details.

如果对于终端用户，客户端是需要有状态的，在第一次登陆后，需要其他授权操作，那么这个客户端后面的所有的请求都应该包含所有服务于这个请求的信息-包括鉴别和授权的详情。
>>No client context shall be stored on the server between requests. The client is responsible for managing the state of the application.

>服务器不保存任何请求的上下文，客户端负责管理应用的所有状态

**Cacheable**
>In today’s world, caching of data and responses is of utmost important wherever they are applicable/possible. The webpage you are reading here is also a cached version of the HTML page. Caching brings performance improvement for the client-side and better scope for scalability for a server because the load has reduced.

如今，只要适用或者可能，对数据和返回结果的缓存都是非常重要的。现如今你在阅读的网页同样也是网页的缓存的一种版本。缓存给客户端带了性能提升并且由于加少了负载，给服务端也带来了
更好的可伸缩性。
>In REST, caching shall be applied to resources when applicable, and then these resources MUST declare themselves cacheable. Caching can be implemented on the server or client-side.

对于REST而言，如果可用的话，缓存就应当尽可能的使用，当然资源必须自声明为可缓存的。无论对于客户端还是服务端，缓存都是可实现的
>>Well-managed caching partially or completely eliminates some client-server interactions, further improving scalability and performance.

>好的缓存可以部分甚至完全的消除客户端和服务端之间的交互，从而进一步提高适用性和性能。

**Layered system**
>REST allows you to use a layered system architecture where you deploy the APIs on server A, and store data on server B and authenticate requests in Server C, for example. A client cannot ordinarily tell whether it is connected directly to the end server, or to an intermediary along the way.

REST允许你使用分层的系统架构，你可以在服务器A上部署APIs，然后在在服务器B上保存数据，然后在服务器C上进行授权。客户端是无法知道它是和终端服务器相连，还是和其中的一个中间件。

**Code on demand (optional)**
>Well, this constraint is optional. Most of the time, you will be sending the static representations of resources in the form of XML or JSON. But when you need to, you are free to return executable code to support a part of your application, e.g., clients may call your API to get a UI widget rendering code. It is permitted.

这是可选的。通常我们是以xml,json等格式发送静态的资源表示。但是，如果你需要的话，你也可以发送应用支持的可运行的代码，如果允许的话，如客户端也许会从api中获取一个UI widget渲染代码。

>>All the above constraints help you build a truly RESTful API, and you should follow them. Still, at times, you may find yourself violating one or two constraints. Do not worry; you are still making a RESTful API – but not “truly RESTful.”

> 以上所有的限制帮助你构建一个正真的RESTful API,当然，有的时候你只遵循了一或两个，但是，这也不要紧，你依然实现了一个RESTful API——只是它不是正真的RESTful而已。

>Notice that all the above constraints are most closely related to WWW (the web). Using RESTful APIs, you can do the same thing with your web services what you do to web pages.

注意，以上所有的限制和WWW(网站）相似，当使用RESTful APIs的时候，你在网页做什么，你在这里也可以做什么。

