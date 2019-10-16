package com.asa.demo.mybatis.mysql.mapper.provider;

import com.asa.demo.mybatis.mysql.mapper.support.TableInfo;
import org.apache.ibatis.builder.annotation.ProviderContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 18:09 2019/10/15.
 */
public abstract class SqlProviderSupport {
    /**
     * 表前缀
     */
    private static final String TABLE_PREFIX = "";

    /**
     * 主键名
     */
    private static final String DEFAULT_PRIMARY_KEY = "id";

    /**
     * key:interface class <-> tableInfo
     */
    private static Map<Class, TableInfo> tableCache = new ConcurrentHashMap<>();

    /**
     * 获取表信息结构
     *
     * @param context 上下文
     * @return 对应的表信息
     */
    protected TableInfo tableInfo(ProviderContext context) {
        TableInfo tableInfo = tableCache.get(context.getMapperType());
        if (tableInfo != null) return tableInfo;

        return null;
    }


    protected Class<?> entityType(ProviderContext context) {
//        Stream.of(context.getMapperType().getGenericInterfaces())
//                .filter(ParameterizedType.class::isInstance)
//                .map(ParameterizedType.class::cast)
//                .filter()
        return null;
    }
}