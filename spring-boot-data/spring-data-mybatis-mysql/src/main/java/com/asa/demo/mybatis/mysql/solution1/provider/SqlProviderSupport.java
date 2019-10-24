package com.asa.demo.mybatis.mysql.solution1.provider;

import com.asa.demo.mybatis.mysql.mapper.BaseMapper;
import com.asa.demo.mybatis.mysql.solution1.support.*;
import com.google.common.base.CaseFormat;
import org.apache.ibatis.builder.annotation.ProviderContext;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

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
    private static final String TABLE_PREFIX = "vwe_";

    private static final String Entity_SUFFIX = "Model";

    /**
     * 主键名
     */
    private static final String DEFAULT_PRIMARY_KEY = "id";

    /**
     * key:interface class <-> tableInfo
     */
    private static Map<Class, TableInfo> tableCache = new ConcurrentHashMap<>(256);

    /**
     * 获取BaseMapper接口中的泛型类型
     *
     * @param context 上下文
     * @return 泛型的类型
     */
    protected Class<?> entityType(ProviderContext context) {
        Class<?> mapperType = context.getMapperType();
        Type[] genericTypes = mapperType.getGenericInterfaces();
        return Stream.of(genericTypes)
                .filter(ParameterizedType.class::isInstance)
                .map(ParameterizedType.class::cast)
                .filter(type -> type.getRawType() == BaseMapper.class)
                .findFirst()
                .map(type -> type.getActualTypeArguments()[0])
                .filter(it -> it instanceof Class)
                .map(it -> (Class) it)
                .orElseThrow(() -> new IllegalArgumentException(String.format("entity of the baseMapper class[%s] is not found",
                        mapperType.getName())));
    }

    /**
     * get table name from entity class
     *
     * @param entity model类
     * @return 对应的表名
     */
    String tableName(Class<?> entity) {
        return TABLE_PREFIX + CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, entity.getSimpleName().replace(Entity_SUFFIX, ""));
    }

    /**
     * 过滤声明为非表列名的属性
     *
     * @param allField 所有的属性
     * @return 列名的属性
     */
    Field[] excludeNoColumnField(Field[] allField) {
        return Stream.of(allField)
                .filter(it -> !it.isAnnotationPresent(NoColumn.class))
                .toArray(Field[]::new);
    }

    /**
     * 获取单个属性对应的数据库字段（带有下划线字段将其转换为"字段 AS pojo属性名"形式）
     *
     * @param field 属性
     * @return 自定义名称的映射
     */
    protected String selectColumnName(Field field) {
        String camel = StringUtils.camel2Underscore(field.getName());
        return camel.contains("_") ? camel + " AS " + field.getName() : camel;
    }

    /**
     * 获取单个属性对应的数据库字段
     *
     * @param field entityClass中的field
     * @return
     */
    protected String columnName(Field field) {
        return StringUtils.camel2Underscore(field.getName());
    }

    /**
     * 获取参数对象的参数值
     *
     * @param bean  参数对象
     * @param field 属性
     * @return 属性值
     */
    protected Object value(Object bean, Field field) {
        try {
            field.setAccessible(true);
            return field.get(bean);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } finally {
            field.setAccessible(false);
        }
    }


    /**
     * 获取查询对应的字段 (不包含pojo中含有@NoColumn主键的属性)
     *
     * @param fields p
     * @return
     */
    protected String[] selectColumns(Field[] fields) {
        return Stream.of(fields).map(this::selectColumnName).toArray(String[]::new);
    }

    /**
     * 获取所有pojo所有属性对应的数据库字段 (不包含pojo中含有@NoColumn主键的属性)
     *
     * @param fields entityClass所有fields
     * @return 对应的数据库字段
     */
    protected String[] columns(Field[] fields) {
        return Stream.of(fields).map(this::columnName).toArray(String[]::new);
    }

    /**
     * 如果fields中含有@Primary的字段，则返回该字段名为主键，否则默认'id'为主键名
     *
     * @param fields entityClass所有fields
     * @return 主键column(驼峰转为下划线)
     */
    protected String primaryKeyColumn(Field[] fields) {
        return Stream.of(fields).filter(field -> field.isAnnotationPresent(Primary.class))
                .findFirst()    //返回第一个primaryKey的field
                .map(this::columnName)
                .orElse(DEFAULT_PRIMARY_KEY);
    }

    /**
     * 获取表信息结构
     *
     * @param context
     * @return
     */
    protected TableInfo tableInfo(ProviderContext context) {
        TableInfo info = tableCache.get(context.getMapperType());
        if (info != null) {
            return info;
        }

        Class<?> entityClass = entityType(context);
        //获取不含有@NoColumn注解的fields
        Field[] fields = excludeNoColumnField(ReflectionUtils.getFields(entityClass));
        TableInfo.TIBuilder builder = new TableInfo.TIBuilder(entityClass);
        info = builder
                .fields(fields)
                .tableName(tableName(entityClass))
                .primaryKeyColumn(primaryKeyColumn(fields))
                .columns(columns(fields))
                .selectColumns(selectColumns(fields))
                .build();

        tableCache.put(context.getMapperType(), info);
        return info;
    }

    /**
     * 构建sql
     *
     * @param criteria 参数
     * @param context  上下文
     * @return 构建出来的sql查询语句
     */
    public abstract String sql(Object criteria, ProviderContext context);

    protected String bindParameter(Field field) {
        return "#{" + field.getName() + "}";
    }
}