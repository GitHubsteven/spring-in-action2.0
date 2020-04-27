#####
spring可以通过泛型指定bean，代码如下：
```java
public class DemoController {
    private final IService<DataBean> iService;
    private final Map<String, IService<?>> serviceMap;

    public DemoController(IService<DataBean> iService, Map<String, IService<?>> serviceMap) {
        this.iService = iService;
        this.serviceMap = serviceMap;
    }

    @GetMapping("/demo/{id}")
    public Object demo(@PathVariable("id") Integer id) {
        return iService.demo();
    }
}
```
上面代码是可行的，符合期望的