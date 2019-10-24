package com.asa.demo.mybatis.mysql.solution2.core;

import com.asa.demo.mybatis.mysql.solution2.provider.HsqldbProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 13:57 2019/10/24.
 */
public interface HsqldbMapper<T> {
    /**
     * 单表分页查询
     *
     * @param object
     * @param offset
     * @param limit
     * @return
     */
    @SelectProvider(type = HsqldbProvider.class, method = "dynamicSQL")
    List selectPage(@Param("entity") T object, @Param("offset") int offset, @Param("limit") int limit);
}