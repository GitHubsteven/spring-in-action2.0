package com.asa.demo.mybatis.mysql.mapper.provider;

import com.asa.demo.mybatis.mysql.mapper.support.TableInfo;
import org.apache.ibatis.builder.annotation.ProviderContext;
import org.apache.ibatis.jdbc.SQL;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 19:57 2019/10/23.
 */
public class CountSqlProvider extends SqlProviderSupport {
    @Override
    public String sql(Object criteria, ProviderContext context) {
        TableInfo tableInfo = tableInfo(context);
        return new SQL()
                .SELECT("count(*")
                .FROM(tableInfo.getTableName())
                .toString();
    }
}