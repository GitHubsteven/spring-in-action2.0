package com.asa.demo.mybatis.mysql.mapper;

import com.asa.demo.mybatis.mysql.mapper.provider.InsertSqlProvider;
import org.apache.ibatis.annotations.InsertProvider;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 18:05 2019/10/15.
 */
public interface BaseMapper<Entity> {
    @InsertProvider(type = InsertSqlProvider.class, method = "sql")
    Integer insert(Entity entity);
}