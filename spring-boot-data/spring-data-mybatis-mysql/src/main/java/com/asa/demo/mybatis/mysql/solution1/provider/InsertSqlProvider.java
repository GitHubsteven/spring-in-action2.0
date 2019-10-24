package com.asa.demo.mybatis.mysql.solution1.provider;

import com.asa.demo.mybatis.mysql.solution1.support.TableInfo;
import org.apache.ibatis.builder.annotation.ProviderContext;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 18:08 2019/10/15.
 */
public class InsertSqlProvider extends SqlProviderSupport {
    @Override
    public String sql(Object criteria, ProviderContext context) {
        TableInfo table = tableInfo(context);
        List<Field> noNullFeilds = Stream.of(table.getFields())
                .filter(field -> value(criteria, field) != null)
                .collect(Collectors.toList());

        return new SQL()
                .INSERT_INTO(table.getTableName())
                .INTO_COLUMNS(noNullFeilds.stream()
                        .map(Field::getName).toArray(String[]::new))
                .INTO_VALUES(noNullFeilds.stream().map(this::bindParameter).toArray(String[]::new))
                .toString();
    }
}