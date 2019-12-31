#### 关于rest api的一些规范和开发模式
参考文档
1.  [什么是REST API](https://blog.csdn.net/qq_42611547/article/details/84346809)
2.  [restfulapi](https://restfulapi.net/)

#### 什么是Rest
> REST is acronym for Representational State Transfer. It is
> architectural style for distributed hypermedia systems and was first
> presented by Roy Fielding in 2000 in his famous dissertation.

Representational State Transfer的缩写，翻译为"表现层状态转化"，由Roy
Fielding在2000年第一次提出，是种分布文本系统的架构风格。它有如下的6个规则限制

###### Guiding Principles of REST
1. Client–server – By separating the user interface concerns from the data storage concerns, we improve the portability of the user interface across multiple platforms and improve scalability by simplifying the server components.
2. Stateless – Each request from client to server must contain all of the information necessary to understand the request, and cannot take advantage of any stored context on the server. Session state is therefore kept entirely on the client.
3. Cacheable – Cache constraints require that the data within a response to a request be implicitly or explicitly labeled as cacheable or non-cacheable. If a response is cacheable, then a client cache is given the right to reuse that response data for later, equivalent requests.
4. Uniform interface – By applying the software engineering principle of generality to the component interface, the overall system architecture is simplified and the visibility of interactions is improved. In order to obtain a uniform interface, multiple architectural constraints are needed to guide the behavior of components. REST is defined by four interface constraints: identification of resources; manipulation of resources through representations; self-descriptive messages; and, hypermedia as the engine of application state.
5. Layered system – The layered system style allows an architecture to be composed of hierarchical layers by constraining component behavior such that each component cannot “see” beyond the immediate layer with which they are interacting.
6. Code on demand (optional) – REST allows client functionality to be extended by downloading and executing code in the form of applets or scripts. This simplifies clients by reducing the number of features required to be pre-implemented.

简单翻译
1. 客户端和服务端——通过从数据存储角度把用户的接口分为客户端和服务端，可以提高接口跨平台的兼容型，并且简化服务器端的组成来提高可扩展性。
2. 无状态——一次请求应当包含所有和必要用来理解这次请求的信息，不能利用保存在服务端的上下文的内容，所以，session应当彻底的保存在客户端
3. 可缓存——缓存限制要求在Response中的数据必须隐性的或者显性的是否可缓存还是不可缓存。如果是可缓存的，客户端被允许可缓存数据用于下次相同的请求。
4. 统一接口——为了满足软件工程的组件通用性原则，整体系统需要简化并且交互的可见性必须提高。为了统一接口，必须要有多个架构限制去引导组件的行为。REST定义了
   四个接口限制：资源的id，通过表现层对资源的操作，自我描述信息和通过超文本作为应用状态的引擎
5. 系统分层——系统分层允许系统由多个分等级限制的组件组成，各个不同等级交互的组件相互不可见
6. 按需编码（可选）——REST允许客户端通过下载或者运行applets或者scripts的代码来拓展客户端的功能。这可以通过减少必要的前置条件来简化客户端

###### Resource
> The key abstraction of information in REST is a resource. Any information that can be named can be a resource: a document or image, a temporal service, a collection of other resources, a non-virtual object (e.g. a person), 
and so on. REST uses a resource identifier to identify the particular resource involved in an interaction between components.

最关键抽象的概念就是资源，任何信息都可以被认为是资源：文档，图片，一个暂时的服务，一个资源的集合，甚至一个现实的（如一个人）等等。REST通过资源id来组件间
交互的资源。
>The state of the resource at any particular timestamp is known as resource representation. A representation consists of data, metadata describing the data and hypermedia links which can help the clients in transition to the next desired state.

资源在任何时刻的状态被认为是resource
representation（资源表现）。一个representation包含数据，用来描述数据的数据版本和帮助客户端可转化资源到想要的状态的链接。
>The data format of a representation is known as a media type. The media type identifies a specification that defines how a representation is to be processed.
 A truly RESTful API looks like hypertext. Every addressable unit of information carries an address, either explicitly (e.g., link and id attributes) or implicitly (e.g., derived from the media type definition and representation structure).

一个representation（表现）的数据格式被认为是媒体格式。媒体格式定义了如何取处理representation（状态）的标准。一个正真的Restful
api
看起来像是超文本。每一个可地址描述的基本信息都带有一个地址，无论是隐性（某些源于媒体类型和representation结构的东西）的还是显性（如：链接和id属性）的。

According to Roy Fielding：
>>Hypertext (or hypermedia) means the simultaneous presentation of
>>information and controls such that the information becomes the
>>affordance through which the user (or automaton) obtains choices and
>>selects actions. Remember that hypertext does not need to be HTML (or
>>XML or JSON) on a browser. Machines can follow links when they
>>understand the data format and relationship types.

根据Roy Fielding所说:
>> 超文本和多媒体意味着信息或控制的同时展现，这意味着，信息对于用户是可以通过获取选项或者选择操作来获取的。记住，超文本并不局限于在浏览器上的html
>> (xml或者json)。如果理解数据格式和关系类型，机器可以访问链接。

>Further, resource representations shall be self-descriptive: the client
>does not need to know if a resource is employee or device. It should
>act on the basis of media-type associated with the resource. So in
>practice, you will end up creating lots of custom media-types –
>normally one media-type associated with one resource.

另外，资源展现应当是自我表述的：客户端无需知道资源是人还是机器。资源展现应基于以结合资源的标准来展现。因此实际上，你会生成很多自定义的媒体类型——通常
和资源是一对一的。

>>Every media type defines a default processing model. For example, HTML defines a rendering process for hypertext and the browser behavior around each element.
 It has no relation to the resource methods GET/PUT/POST/DELETE/… other than the fact that some media type elements will define a process model that goes like “anchor elements with an href attribute create a hypertext link that, when selected, invokes a retrieval request (GET) on the URI corresponding to the CDATA-encoded href attribute.”
 
 每个媒体类型定义了一个默认的处理方式，如html定义了对于超文本的渲染处理和浏览器对于节点的行为，它和资源方法如GET/POST/DELETE...没有任何关系，它和某些定义了自带行为如"带连接
 属性的元素会生成带有链接的超文本链接，当这个超文本链接当被选择时，会基于按CDATA加密的链接属性去调用一些请求（Get)"也没有关系。
 
###### Resource Methods（资源方法）

>Another important thing associated with REST is resource methods to be used to perform the desired transition. A large number of people wrongly relate resource methods to HTTP GET/PUT/POST/DELETE methods.

另一个和REST重要相关的就是资源方法（resource
method)，资源方法用来描述目标转化。许多人**误** 把HTTP
GET/POST/PUT/DELETE方法联系到一起。

>Roy Fielding has never mentioned any recommendation around which method to be used in which condition. All he emphasizes is that it should be uniform interface.
 If you decide HTTP POST will be used for updating a resource – rather than most people recommend HTTP PUT – it’s alright and application interface will be RESTful.

Roy Field从未提过关于在何种状态下用何种方法的建议。他只强调过接口的统一性，如果你在更新的时候用POST，而不是大多数人推荐的HTTP
PUT——那也无所谓，应用接口也是Restful.
>Ideally, everything that is needed to change the resource state shall be part of API response for that resource – including methods and in what state they will leave the representation.

理想状态下，api response应当包含所有改变resource状态的的东西——包括方法和resource从何种状态离开。
>>A REST API should be entered with no prior knowledge beyond the initial URI (bookmark) and set of standardized media types that are appropriate for the intended audience (i.e., expected to be understood by any client that might use the API). From that point on, all application state transitions must be driven by client selection of server-provided choices that are present in the received representations or implied by the user’s manipulation of those representations. The transitions may be determined (or limited by) the client’s knowledge of media types and resource communication mechanisms, both of which may be improved on-the-fly (e.g., code-on-demand).
[Failure here implies that out-of-band information is driving interaction instead of hypertext.]

一个REST
API，应当在除了初始URI不需要其他前置条件，并且有一系列适用于接口使用者的多媒体标准来访问（被期待为可以被任何可能使用接口的人理解）。所有应用程序状态转换都必须由客户端对接收到的表示形式中存在的或用户对这些表示形式的操作隐含的服务器提供的选择进行选择来驱动。
一个转化取决于或受限于客户端对媒体类型的认识或者资源的交互机制，而这两者都可能通过代码即使提高。[在这里失败意味着额外的信息正在驱动交互而非超文本]

>Another thing which will help you while building RESTful APIs is that
>query based API results should be represented by a list of links with
>summary information, not by arrays of original resource representations
>because the query is not a substitute for identification of resources.

另外，在构建RESTful
APIs的时候，查询结果应当是一些总结性的结果的链接，而非是一些列最原始的资源表现，因为查询不是资源身份的订阅。

###### REST and HTTP are not same

> A lot of people prefer to compare HTTP with REST. REST and HTTP are
> not same.

许多人倾向于比较HTTP和REST，然而REST和HTTP是不同的。
>Though, because REST also intends to make the web (internet) more streamline and standard, he advocates using REST principles more strictly. And that’s from where people try to start comparing REST with web (HTTP). Roy fielding, in his dissertation, nowhere mentioned any implementation directive – including any protocol preference and HTTP. Till the time, you are honoring the 6 guiding principles of REST, you can call your interface RESTful.

但是，由于REST还打算使Web（互联网）更加简化和标准，因此他主张更严格地使用REST原理。这正是为什么人们尝试开始去比较两者。然而， Roy
fielding，在他的论文中，没有任何地方直接提到了实现方案——无论任何的协和，即使是HTTP。如今，在遵循REST的6大规则后，你也可以自己定义自己的接口为RESTful。

>In simplest words, in the REST architectural style, data and
>functionality are considered resources and are accessed using Uniform
>Resource Identifiers (URIs). The resources are acted upon by using a
>set of simple, well-defined operations. The clients and servers
>exchange representations of resources by using a standardized interface
>and protocol – typically HTTP.

简而言之，在REST架构中，数据和方法通过统一资源身份id来获取，资源通过使用一系列简单，容易定义的操作来处。客户端和服务端通过使用标注的接口和协议——典型的是http，来交互资源状态。

>Resources are decoupled from their representation so that their content
>can be accessed in a variety of formats, such as HTML, XML, plain text,
>PDF, JPEG, JSON, and others. Metadata about the resource is available
>and used, for example, to control caching, detect transmission errors,
>negotiate the appropriate representation format, and perform
>authentication or access control. And most importantly, every
>interaction with a resource is stateless.

资源从表现形式解耦是为了让他们的内容可以有更多的形式，如html,xml,plain
text,pdf,jpeg,json等等。资源的数据版本是可获取和可用的，例如，去控制缓存，查找交互错误，引导数据的正确表现，权限验证或者权限控制。最重要的是，每次交互都是无状态的。

>All these principles help RESTful applications to be simple,
>lightweight, and fast.

这些标准让RESTful应用更加简单，轻量好快速。


References:（参考）

[rest-apis-must-be-hypertext-driven](http://roy.gbiv.com/untangled/2008/rest-apis-must-be-hypertext-driven)

[rest_arch_style](http://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm)