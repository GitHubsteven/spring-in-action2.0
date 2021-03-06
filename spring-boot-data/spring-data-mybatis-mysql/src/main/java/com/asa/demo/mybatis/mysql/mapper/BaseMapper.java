package com.asa.demo.mybatis.mysql.mapper;

import com.asa.demo.mybatis.mysql.solution1.provider.CountByCriteriaSqlProvider;
import com.asa.demo.mybatis.mysql.solution1.provider.CountSqlProvider;
import com.asa.demo.mybatis.mysql.solution1.provider.InsertSqlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @date: Created at 18:05 2019/10/15.
 */
public interface BaseMapper<Entity> {
    @InsertProvider(type = InsertSqlProvider.class, method = "sql")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer insert(Entity entity);

    @SelectProvider(type = CountSqlProvider.class, method = "sql")
    Long count();

    @SelectProvider(type = CountByCriteriaSqlProvider.class, method = "sql")
    Long countByCriteria(Entity model);
}