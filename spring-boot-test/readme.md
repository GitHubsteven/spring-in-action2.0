#### build spring blocks

##### 1. spring boot test context
1. Use springBootTest + RunWith(SpringJUnit4ClassRunner.class)

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

2. Use the @ContextConfiguration()

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