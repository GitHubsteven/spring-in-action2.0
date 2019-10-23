package com.asa.demo.mybatis.mysql.mapper.provider;

import com.asa.demo.mybatis.mysql.mapper.support.TableInfo;
import org.apache.ibatis.builder.annotation.ProviderContext;
import org.apache.ibatis.jdbc.SQL;

import java.util.stream.Stream;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 20:31 2019/10/23.
 */
public class DeleteByCriteriaSqlProvider extends SqlProviderSupport {
    @Override
    public String sql(Object criteria, ProviderContext context) {
        TableInfo table = tableInfo(context);

        return new SQL()
                .DELETE_FROM(table.getTableName())
                .WHERE(Stream.of(table.getFields())
                        .filter(field -> value(criteria, field) != null)
                        .map(field -> columnName(field) + " = " + bindParameter(field))
                        .toArray(String[]::new))
                .toString();
    }
}