package pers.deom.asa.freemarker;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pers.demo.asa.freemarker.FreemarkerUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 17:09 2019/11/7.
 */
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