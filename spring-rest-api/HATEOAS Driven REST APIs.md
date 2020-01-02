##### HATEOAS Driven REST APIs

>HATEOAS (Hypermedia as the Engine of Application State) is a constraint of the REST application architecture that keeps the RESTful style architecture unique from most other network application architectures. The term “hypermedia” refers to any content that contains links to other forms of media such as images, movies, and text.

HATEOAS(超媒体驱动应用状态)是使REST应用架构风格区别于其他网络应用架构的约束，任何包括了指向其他格式的媒体如图片
视频或者文本链接的内容都可以叫“超媒体”。
>REST architectural style lets you use hypermedia links in the response contents so that the client can dynamically navigate to the appropriate resource by traversing the hypermedia links. Above is conceptually the same as a web user browsing through web pages by clicking the relevant hyperlinks to achieve a final goal.

在REST架构风格中，你可以使用返回结果中的链接，因此，客户端可以通过遍历超文本链接动态的导向合适的资源。从概念上来说，这和用户在网页上
在浏览的时候，通过点击超文本相关链接访问到最终的目标相同。

>For example, below given JSON response may be from an API like HTTP GET http://api.domain.com/management/departments/10

例如，下面的就是一个来自HTTP GET请求“http://api.domain.com/management/departments/10”的API的json返回结果
```
{
    "departmentId": 10,
    "departmentName": "Administration",
    "locationId": 1700,
    "managerId": 200,
    "links": [
        {
            "href": "10/employees",
            "rel": "employees",
            "type" : "GET"
        }
    ]
}
```
>In the preceding example, the response returned by the server contains hypermedia links to employee resources 10/employees, which can be traversed by the client to read employees belonging to the department.

在前面的例子中，服务器返回的结果包含了指向资源10/employees的超媒体链接，客户端可以通过这个链接访问这个部门的员工。

>The advantage of the above approach is that hypermedia links returned from the server drive the application’s state and not the other way around.

上面的优势是，驱动应用的状态是从服务器返回的结果包含的超媒体链接而不是其他的方法。
>There is no universally accepted format for representing links between two resources in JSON. You may choose to adopt the above format, or you may choose to send links in HTTP response headers.

关于两个json资源展示链接，没有普世的规范。你可以选择上面的链接，当然，你也可以通过http返回结果头去发送链接。
```
HTTP/1.1 200 OK
...
Link: <10/employees>; rel="employees"
```
两者都是有效的方案。

##### HATEOAS Implementation
>In the real world, when you visit a website – you hit its homepage. It presents some snapshots and links to other sections of websites. You click on them, and then you get more information along with more related links that are relevant to the context.

生活中，当你访问一个网站的时候，你点击它的主页。主页会展示一些快照和访问其他部分的链接。你点击这些链接，然后你会获得更多和内容相关的链接。
>Similar to a human’s interaction with a website, a REST client hits an initial API URI and uses the server-provided links to dynamically discover available actions and access the resources it needs. The client need not have prior knowledge of the service or the different steps involved in a workflow. Additionally, the clients no longer have to hard code the URI structures for different resources. HATEOAS allows the server to make URI changes as the API evolves without breaking the clients.

和人类访问网站类似，一个REST客户端调用一个最初始的API URI，然后通过服务端提供的链接去动态的发现资源相关的行为和获取它相关的资源。客户端无需预先知道某些东西或者在
工作流之间的不同步骤。另外，客户端无需为不同的资源写死代码。HATEOAS允许服务端在开发的过程修改URI，但是却不会影响客户端。
>Above API interaction is possible using HATEOAS only.

上面的API交互只有使用HATEOAS才有可能
>Each REST framework provides it’s own way on creating the HATEOAS links using framework capabilities e.g. in this [RESTEasy HATEOAS tutorial](https://howtodoinjava.com/resteasy/writing-restful-webservices-with-hateoas-using-jax-rs-and-jaxb-in-java/) , links are part of resource model classes which is transferred as resource state to the client.

每一个REST架构提供了基于自己架构能力生成的HATEOAS链接的方法。例如，在[RESTEasy HATEOAS tutorial](https://howtodoinjava.com/resteasy/writing-restful-webservices-with-hateoas-using-jax-rs-and-jaxb-in-java/)这里，链接是放在那些用作资源状态转化传递给
客户端的model中的。

##### HATEOAS References

>The following are the two popular formats for specifying JSON REST API hypermedia links:

下面是关于制定JSON REST API超媒体链接受欢迎的两个格式规范。

**RFC 5988 (web linking)**

>[RFC 5988](https://tools.ietf.org/html/rfc5988) puts forward a framework for building links that defines the relation between resources on the web. Each link in RFC 5988 contains the following properties:

[RFC 5988](https://tools.ietf.org/html/rfc5988)提出了一个用于构建那些在网页上表示两个资源之间的关系的链接的架构。每个符合RFC 5988规范的链接包含如下元素：

>*Target URI*: Each link should contain a target Internationalized Resource Identifiers (IRIs). This is represented by the href attribute.

*目标的统一资源标识符*: 每个链接应当包含一个目标国际化资源标识符（IRIs).这通过href属性来表示。 

>*Link relation type*: The link relation type describes how the current context (source) is related to the target resource. This is represented by the rel attribute.

*链接关系类型*：链接关系类型描述了当前资源（来源）和目标资源的关系。这通过rel属性来表示

>*Attributes for target IRI*: The attributes for a link include hreflang, media, title, and type, and any extension link parameters.
*用于目标国际化资源标识符的属性*：链接属性有：hreflang, media, title, 和 type，和链接任何其他的相关扩展。

**JSON Hypermedia API Language (HAL)**
> [JSON HAL](https://en.wikipedia.org/wiki/Hypertext_Application_Language) is a promising proposal that sets the conventions for expressing hypermedia controls, such as links, with JSON or XML. It is in the draft stage at this time.

[JSON HAL](https://en.wikipedia.org/wiki/Hypertext_Application_Language)是一种约定性建议，它定义了一系列规则，规则规定了如何表示超媒体控制，如通过json或者xml表示链接。迄今为止还只是起草阶段。
>The two associated MIME types are

两个相关的MIME类型是：
```
media type: application/hal+xml 
media type: application/hal+json
```

>Each link in HAL may contain the following properties:

每个HAL链接包含如下两个属性

> *Target URI*: It indicates the target resource URI. This is represented by the href attribute.

*目标的统一话资源标识符*： 它表示一个目标国际化资源标识符（IRIs).这通过href属性来表示
> *Link relation*: The link relation type describes how the current context is related to the target resource. This is represented by the rel attribute.

*链接关系*：链接关系类型描述了当前文本和目标资源的关系。这通过rel属性来表示
> *Type*: This indicates the expected resource media type. This is represented by the type attribute.
*类型*: 这表明了期望的资源媒体类型， 通过type属性来表示
>There is no right or wrong in choosing a hypermedia link format for your application. You should pick up a format that meets most of your use case requirements and stick to it.

对于应用来说，选择哪个没有对错。你应当选择能满足你最多需求的并且坚持下去。