#### build spring blocks

##### 1. spring boot test context based on the spring boot
1. Use the @ContextConfiguration() based on spring mvc

Use the @ContextConfiguration to configure the sprint IOC container context, code like the following
```
@RunWith(SpringRunner.class)
//@ContextConfiguration(classes =BeanDIConf.class)  //(method:1)
@ContextConfiguration(classes = DemoServiceTest.TestConfig.class)   //(method 2)
public class DemoServiceTest {
    @Autowired
    private DemoService demoService;

    @Test
    public void testIntroduce() {
        System.out.println(demoService.introduce());
    }

    @Configuration
    @ComponentScan("com.asa.demo.spring.*")
    public static class TestConfig {

    }
}
``` 
configure the context by the config class.

2. Use springBootTest + RunWith(SpringJUnit4ClassRunner.class)

2.1  test the inner service

Spring boot test case, reference document see: [Testing the Web Layer](https://spring.io/guides/gs/testing-web/)
Code like the following
```
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BaseServiceTest {
}
```
> The @SpringBootTest annotation tells Spring Boot to go and look for a main configuration class (one with @SpringBootApplication for instance), 
and use that to start a Spring application context. You can run this test in your IDE or on the command line (mvn test or gradle test) and it should pass.

2.2 httpRequest Test

See the http [HttpRequestTest.java](../src/test/java/java/com/asa/demo/spring/boot/test/service/HttpRequestTest.java)
code like the following:
```
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testGetApiRequest() {
        String result = testRestTemplate.getForObject(String.format("http://localhost:%d/hi/home", port), String.class);
        Assertions.assertThat(result).contains("home");
    }
}
```
>Note the use of webEnvironment=RANDOM_PORT to start the server with a random port (useful to avoid conflicts in test environments), 
and the injection of the port with @LocalServerPort.Also note that Spring Boot has provided a TestRestTemplate for you automatically, 
and all you have to do is @Autowired it.

consult the following code if header needed to be set:
```
    @Before
    public void setUp() {
        //set header user info
        testRestTemplate.getRestTemplate()
                .setInterceptors(Collections.singletonList((request, body, execution) -> {
                    request.getHeaders()
                            .add("X-Requested-User", "{\"companyId\":10125,\"username\":\"user\",\"language\":\"CN\"}");
                    return execution.execute(request, body);
                }));
    }
```
or
```
HttpHeaders headers = new HttpHeaders();
headers.add("your_header", "its_value");
template.exchange(base, HttpMethod.GET, new HttpEntity<>(headers), Page.class);
```


2.3 HttpRequest test by mockMvc

See the http [HttpRequestTest.java](../src/test/java/java/com/asa/demo/spring/boot/test/service/ApplicationTest.java)
Code like the following:
```
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnMessageHavingHome() throws Exception {
        this.mockMvc.perform(get("/hi/home"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("home")));
    }
}
```
>nother useful approach is to not start the server at all, but test only the layer below that, where Spring handles the incoming HTTP request and hands it off to your controller. 
That way, almost the full stack is used, and your code will be called exactly the same way as if it was processing a real HTTP request, but without the cost of starting the server. 
To do that we will use Spring’s MockMvc, and we can ask for that to be injected for us by using the @AutoConfigureMockMvc annotation on the test case.

2.4 WebLayerTest

See the http [WebLayer.java](../src/test/java/java/com/asa/demo/spring/boot/test/service/WebLayer.java)
Code looks like the following:
```
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(HelloController.class)
public class WebLayerTest {
    @Autowired
    private MockMvc mockMvc;

    //throw a exception if there is no injected required bean in the controller
    @MockBean
    private HelloService service;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/hi/home"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("home")));
    }
}
```

