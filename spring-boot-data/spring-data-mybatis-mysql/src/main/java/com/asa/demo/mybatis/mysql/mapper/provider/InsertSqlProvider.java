package com.asa.demo.mybatis.mysql.mapper.provider;

import com.asa.demo.mybatis.mysql.mapper.support.TableInfo;
import org.apache.ibatis.builder.annotation.ProviderContext;
import org.apache.ibatis.jdbc.SQL;

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

        return new SQL()
                .INSERT_INTO(table.getTableName())
                .INTO_COLUMNS(table.getColumns())
                .INTO_VALUES(Stream.of(table.getFields()).map(this::bindParameter).toArray(String[]::new))
                .toString();
    }
}