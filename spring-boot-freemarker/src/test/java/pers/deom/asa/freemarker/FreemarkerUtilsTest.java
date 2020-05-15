package pers.deom.asa.freemarker;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pers.demo.asa.freemarker.FreemarkerUtil;
import pers.demo.asa.freemarker.model.TField;
import pers.demo.asa.freemarker.model.Table;

import java.util.*;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @date: Created at 17:09 2019/11/7.
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

    /**
     * test target
     * <p>
     * if isPrimaryKey
     * if isNotId
     * declare as primary key, @PrimaryKey
     */
    @Test
    public void test01() {
        // 填充数据
        rootMap.put("packages", Arrays.asList("jet.baomidou", "book", "grace.baomidou"));
        rootMap.put("exclude", Boolean.TRUE);
        rootMap.put("table", creatTable());
        // 打印到控制台
        freemarkerUtil.print("01.ftl", rootMap);
        // 输出到文件
//        freemarkerUtil.fprint("01.ftl", rootMap, "01.html");
    }

    private Table creatTable() {
        Table table = new Table();
        //create the primary key
        TField primaryKey = new TField();
        primaryKey.setIsPK(true);
        primaryKey.setName("notId");
        primaryKey.setTypeName("Long");

        TField commonColumn = new TField();
        commonColumn.setIsPK(false);
        commonColumn.setName("commonColumn");
        commonColumn.setTypeName("String");

        List<TField> fields = new ArrayList<>();
        fields.add(primaryKey);
        fields.add(commonColumn);

        table.setFields(fields);
        table.setName("TestTable");
        return table;
    }
}