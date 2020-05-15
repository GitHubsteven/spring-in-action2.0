package com.asa.demo.mybatis.mysql.solution1.provider;

import com.asa.demo.mybatis.mysql.solution1.support.TableInfo;
import org.apache.ibatis.builder.annotation.ProviderContext;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @date: Created at 20:32 2019/10/23.
 */
public class SelectAllSqlProvider extends SqlProviderSupport {
    @Override
    public String sql(Object criteria, ProviderContext context) {
        return sql(null, criteria, context);
    }

    public String sql(String orderBy, Object criteria, ProviderContext context) {
        TableInfo table = tableInfo(context);
        SQL sql = new SQL()
                .SELECT(table.getSelectColumns())
                .FROM(table.getTableName());
        if (StringUtils.isEmpty(orderBy)) {
            orderBy = table.getPrimaryKeyColumn() + " DESC";
        }
        return sql.ORDER_BY(orderBy).toString();
    }
}