#### REST Resource Naming Guide

文档链接： [resource-naming](https://restfulapi.net/resource-naming/)

>In REST, primary data representation is called Resource. Having a strong and consistent REST resource naming strategy – will definitely prove one of the best design decisions in the long term.

在REST中，初始的数据表现被叫做资源。从长期来看，拥有一个强壮的一致的资源命名规则理所当然的会是一个极好的设计决定。

>>The key abstraction of information in REST is a resource. Any information that can be named can be a resource: a document or image, a temporal service (e.g. “today’s weather in Los Angeles”), a collection of other resources, a non-virtual object (e.g., a person), and so on. In other words, any concept that might be the target of an author’s hypertext reference must fit within the definition of a resource. A resource is a conceptual mapping to a set of entities, not the entity that corresponds to the mapping at any particular point in time.

——Roy Fielding’s dissertation

>A resource can be a singleton or a collection. For example, “customers” is a collection resource and “customer” is a singleton resource (in a banking domain). We can identify “customers” collection resource using the URI “/customers”. We can identify a single “customer” resource using the URI “/customers/{customerId}”.

一个资源可以是单个的，也可以是个集合。例如，在银行系统中，“customers”表示资源集合，而"customer"只是一个单独的资源。我们可以通过uri
"/customers"来确定“customers”,我们可以通过uri“/customers/{customerId}”来确定一个“customer”资源。

>A resource may contain sub-collection resources also. For example, sub-collection resource “accounts” of a particular “customer” can be identified using the URN “/customers/{customerId}/accounts” (in a banking domain). Similarly, a singleton resource “account” inside the sub-collection resource “accounts” can be identified as follows: “/customers/{customerId}/accounts/{accountId}”.

一个资源也许包含了子资源集合，例如，某个特定“customer”的子集合资源“accounts”，可以通过URN
“/customers/{customerId}/accounts”来确定（在银行系统中），类似的，在子资源集合中的一个子资源可以通过“/customers/{customerId}/accounts/{accountId}”来确认。

>REST APIs use Uniform Resource Identifiers (URIs) to address resources. REST API designers should create URIs that convey a REST API’s resource model to its potential client developers. When resources are named well, an API is intuitive and easy to use. If done poorly, that same API can feel difficult to use and understand.

REST APIs用URIs（统一资源身份id）来定位资源，REST
APIs设计者应当设计那些可以传递一个REST
APIs资源模型给那些潜在的客户端开发者的URIs。当资源被命名的很好的话，一个API会很好的理解和使用，反之则难以理解。

>  The constraint of uniform interface is partially addressed by the
>  combination of URIs and HTTP verbs and using them in line with the
>  standards and conventions.

*统一接口的约束通过URIs 和HTTP
动词结合并且通过一些标准和规则使他们整合在一条线上来解决*

>Below are a few tips to get you going when creating the resource URIs
>for your new API.

如下是一些生成resource URIs的小技巧

#### REST Resource Naming Best Practices
##### Use nouns to represent resources 
通过名词来展示资源 
>RESTful URI should refer to a resource that is a thing
(noun) instead of referring to an action (verb) because nouns have
properties which verbs do not have – similar to resources have
attributes. Some examples of a resource are:

RESTful
URI应当关联一个事情（名词）而非一个动作，因为名词有一些动词没有的特性，类似资源有属性。例子如下：
- Users of the system
- User Accounts
- Network Devices etc.

> and their resource URIs can be designed as below: 

然后它们的URIs可被设计成如下： 
```
http://api.example.com/device-management/managed-devices 
http://api.example.com/device-management/managed-devices/{device-id} 
http://api.example.com/user-management/users/
http://api.example.com/user-management/users/{id}
```

>For more clarity, let’s divide the resource archetypes into four categories (document, collection, store and controller) and then you should always target to put a resource into one archetype and then use it’s naming convention consistently. For uniformity’s sake, resist the temptation to design resources that are hybrids of more than one archetype.

为了更好的说明，我们把资源原型分为四个类型（文档，集合，存储和控制）并且你应该确保把资源放在某个层次上去并且统一使用命名规则。出于统一考虑，
*请抵制混杂多个类型的混合命名的诱惑*

1. **document**
>A document resource is a singular concept that is akin to an object instance or database record. In REST, you can view it as a single resource inside resource collection. A document’s state representation typically includes both fields with values and links to other related resources.

一个文档资源是一个单独概念，它类似于一个对象实例或者数据库的记录。在REST,你可以把它看做是集合中的一个对象。一个文档的表现包含了带值的属性和只想其他相关资源的链接

>Use “singular” name to denote document resource archetype.

使用“单数”名称去描述文档资源类型
```
http://api.example.com/device-management/managed-devices/{device-id}
http://api.example.com/user-management/users/{id}
http://api.example.com/user-management/users/admin
```

2.  **collection**

>A collection resource is a server-managed directory of resources. Clients may propose new resources to be added to a collection. However, it is up to the collection to choose to create a new resource or not. A collection resource chooses what it wants to contain and also decides the URIs of each contained resource.

集合资源是服务器管理的资源目录。客户端也许会提出添加一个资源到集合，但是，由集合决定是否创建新资源，集合资源决定它包含什么和它下面每个资源的URIs。

>Use “plural” name to denote collection resource archetype.

使用“复数”去展示集合资源的类型

```
http://api.example.com/device-management/managed-devices
http://api.example.com/user-management/users
http://api.example.com/user-management/users/{id}/accounts
```

3. **store**
>A store is a client-managed resource repository. A store resource lets an API client put resources in, get them back out, and decide when to delete them. A store never generates new URIs. Instead, each stored resource has a URI that was chosen by a client when it was initially put into the store.

一个store是一个客户端管理的资源仓库。一个store资源让一个API客户端保存资源，拿出资源，并且决定什么时候去删除资源。一个store资源从不生成新的URIs。
相反，每个被保存的资源有一个当资源被放进store后被关闭的URI。

>Use “plural” name to denote store resource archetype.

使用“复数”去展示集合资源的类型
```
http://api.example.com/cart-management/users/{id}/carts
http://api.example.com/song-management/users/{id}/playlists
```

4. **controller**
>A controller resource models a procedural concept. Controller resources are like executable functions, with parameters and return values; inputs and outputs.

控制器资源阐释了程序概念。Controller资源就像可运行的函数，有参数，返回值，输入和输出。
>Use “plural” name to denote collection resource archetype.

使用“复数”去展示集合资源的类型
```
http://api.example.com/cart-management/users/{id}/cart/checkout
http://api.example.com/song-management/users/{id}/playlist/play
```
##### Consistency is the key

> Use consistent resource naming conventions and URI formatting for minimum ambiguily and maximum readability and maintainability. You may implement below design hints to achieve consistency:

使用一直的资源命名规则和URI格式去最小化不清楚，最大化可读性和可读性。可以遵循以下的设计提示去保持一致性
1. **Use forward slash (/) to indicate hierarchical relationships（使用正斜杠来分层）**
> The forward slash (/) character is used in the path portion of the URI to indicate a hierarchical relationship between resources. e.g.

在URI路径部分通过正斜杠来表示各个级别的关系，如：
```
http://api.example.com/device-management
http://api.example.com/device-management/managed-devices
http://api.example.com/device-management/managed-devices/{id}
http://api.example.com/device-management/managed-devices/{id}/scripts
http://api.example.com/device-management/managed-devices/{id}/scripts/{id}
```
2. **Do not use trailing forward slash (/) in URIs（不要在末尾使用正斜杠）**
>As the last character within a URI’s path, a forward slash (/) adds no semantic value and may cause confusion. It’s better to drop them completely.

最为URI的路径的最后一个字符，正斜杠没有意义而且可能会然人迷惑，最好是把它删除。

```
http://api.example.com/device-management/managed-devices/
http://api.example.com/device-management/managed-devices 	/*This is much better version*/
```

3. **Use hyphens (-) to improve the readability of URIs（使用连接符号）**
>To make your URIs easy for people to scan and interpret, use the hyphen (-) character to improve the readability of names in long path segments.

为了使URIs让人更容易读和理解，在长路径中使用连字号（-）去增加名字的可读性
```
http://api.example.com/inventory-management/managed-entities/{id}/install-script-location  //More readable
http://api.example.com/inventory-management/managedEntities/{id}/installScriptLocation  //Less readable
```
4. **Do not use underscores ( _ )（不要使用下划线符号）**
>It’s possible to use an underscore in place of a hyphen to be used as separator – But depending on the application’s font, it’s possible that the underscore (_) character can either get partially obscured or completely hidden in some browsers or screens.

在使用连字号（-）作为分隔符的情形下，使用下划线(_)字符也是很有可能的-但是这取决于应用的字体，在某些浏览器或屏幕中，下划线(_)字符可能会被部分掩盖或完全隐藏。
> To avoid this confusion, use hyphens (-) instead of underscores ( _ ).

为了避免混淆，使用连字符(-)代替下划线符号( _ )
```
http://api.example.com/inventory-management/managed-entities/{id}/install-script-location  //More readable
http://api.example.com/inventory_management/managed_entities/{id}/install_script_location  //More error prone
```

5. **Use lowercase letters in URIs（使用小写）**

>When convenient, lowercase letters should be consistently preferred in URI paths.
RFC 3986 defines URIs as case-sensitive except for the scheme and host components. e.g.

如果可以，在URI路径中小写是被推荐的，RFC 3986规范中定义了URIs除了scheme和host部分其他是大小写敏感的。
```
http://api.example.org/my-folder/my-doc  //1
HTTP://API.EXAMPLE.ORG/my-folder/my-doc  //2
http://api.example.org/My-Folder/my-doc  //3
```
>In above examples, 1 and 2 are same but 3 is not as it uses My-Folder in capital letters.

在上面，1和2是相同的，但是和3是不同的，因为3中My-Folder使用了首部大写。

5. **Do not use file extenstions（不要增加文件后缀）**
>File extensions look bad and do not add any advantage. Removing them decreases the length of URIs as well. No reason to keep them.
Apart from above reason, if you want to highlight the media type of API using file extenstion then you should rely on the media type, as communicated through the Content-Type header, to determine how to process the body’s content.

文件扩展看起来很不好并且没有任何优势，移除可以减少URIs的长度。没有任何理由去用它。除了上述的理由，如果你想强调使用了文件扩展名的API的媒体类型，你应当用媒体类型，通过“Content-Type”请求头来交互，
去说明如何处理请求内容。
```
http://api.example.com/device-management/managed-devices.xml  /*Do not use it*/
http://api.example.com/device-management/managed-devices 	/*This is correct URI*/
```

##### Never use CRUD function names in URIs
>URIs should not be used to indicate that a CRUD function is performed. URIs should be used to uniquely identify resources and not any action upon them. HTTP request methods should be used to indicate which CRUD function is performed.

URIs不应当被使用去表明一个CRUD函数被执行。URIs应当仅仅被使用为确定资源，并且在里面不应该包含任何动作。HTTP请求方法才是应当被使用去说明什么CRUD被执行。

```
HTTP GET http://api.example.com/device-management/managed-devices  //Get all devices
HTTP POST http://api.example.com/device-management/managed-devices  //Create new Device

HTTP GET http://api.example.com/device-management/managed-devices/{id}  //Get device for given Id
HTTP PUT http://api.example.com/device-management/managed-devices/{id}  //Update device for given Id
HTTP DELETE http://api.example.com/device-management/managed-devices/{id}  //Delete device for given Id
```

##### Use query component to filter URI collection

>Many times, you will come across requirements where you will need a collection of resources sorted, filtered or limited based on some certain resource attribute. For this, do not create new APIs – rather enable sorting, filtering and pagination capabilities in resource collection API and pass the input parameters as query parameters. e.g.

很多时候，你会遇到这些请求，你需要通过资源的某些属性去排序，过滤或者限制资源集合。为了实现这个，不要生成一个新的api,因为在资源集合API中可以实现排序，过滤和分页，并且
传入参数作为查询参数。
```
http://api.example.com/device-management/managed-devices
http://api.example.com/device-management/managed-devices?region=USA
http://api.example.com/device-management/managed-devices?region=USA&brand=XYZ
http://api.example.com/device-management/managed-devices?region=USA&brand=XYZ&sort=installation-date
```