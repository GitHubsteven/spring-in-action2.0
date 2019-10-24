package com.asa.demo.mybatis.mysql.solution1.provider;

import com.asa.demo.mybatis.mysql.solution1.support.TableInfo;
import org.apache.ibatis.builder.annotation.ProviderContext;
import org.apache.ibatis.jdbc.SQL;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 20:23 2019/10/23.
 */
public class BatchInsertSqlProvider extends SqlProviderSupport {
    @Override
    public String sql(Object entities, ProviderContext context) {
        TableInfo table = tableInfo(context);

        int size = ((List) ((Map) entities).get("list")).size();
        String value = "(" + String.join(",", Stream.of(table.getFields()).map(this::bindParameter).toArray(String[]::new)) + ")";
        String[] values = new String[size];
        Arrays.fill(values, value);

        SQL sql = new SQL()
                .INSERT_INTO(table.getTableName())
                .INTO_COLUMNS(table.getColumns());
        StringBuilder sqlBuilder = new StringBuilder(sql.toString());
        sqlBuilder.append(" VALUES ");
        sqlBuilder.append(String.join(",", values));
        return sqlBuilder.toString();
    }
}