#### Freemarker 的基础使用

list的遍历和过滤 
```
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<#list users?filter(ele-> !(exclude && ele?contains("baomidou"))) as user>
    ${user}
</#list>
</body>
</html> 
```

test例子 
```
@RunWith(JUnit4.class)
public class FreemarkerUtilsTest {
    private FreemarkerUtil freemarkerUtil;
    private Map<String, Object> rootMap = null;

    @Before
    public void setUp() {
        freemarkerUtil = new FreemarkerUtil();
        rootMap = new HashMap<>();
    }

    @Test
    public void test01() {
        // 填充数据
        rootMap.put("users", Arrays.asList("jet.baomidou", "book", "grace.baomidou"));
        rootMap.put("exclude", Boolean.FALSE);
        // 打印到控制台
        freemarkerUtil.print("01.ftl", rootMap);
        // 输出到文件
//        freemarkerUtil.fprint("01.ftl", rootMap, "01.html");
    }
}
```