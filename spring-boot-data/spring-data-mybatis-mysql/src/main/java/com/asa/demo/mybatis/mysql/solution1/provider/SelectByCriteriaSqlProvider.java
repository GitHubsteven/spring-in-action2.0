package com.asa.demo.mybatis.mysql.solution1.provider;

import com.asa.demo.mybatis.mysql.solution1.support.TableInfo;
import org.apache.ibatis.builder.annotation.ProviderContext;
import org.apache.ibatis.jdbc.SQL;

import java.util.stream.Stream;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @date: Created at 20:18 2019/10/23.
 */
public class SelectByCriteriaSqlProvider extends SqlProviderSupport {
    @Override
    public String sql(Object criteria, ProviderContext context) {
        TableInfo table = tableInfo(context);
        return new SQL()
                .SELECT(table.getSelectColumns())
                .FROM(table.getTableName())
                .WHERE(Stream.of(table.getFields())
                        .filter(field -> value(criteria, field) != null)
                        .map(field -> columnName(field) + " = " + bindParameter(field))
                        .toArray(String[]::new)).ORDER_BY(table.getPrimaryKeyColumn() + " DESC").toString();
    }
}