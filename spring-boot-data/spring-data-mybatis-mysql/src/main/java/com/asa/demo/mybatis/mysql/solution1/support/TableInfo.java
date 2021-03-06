package com.asa.demo.mybatis.mysql.solution1.support;

import javafx.util.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.lang.reflect.Field;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @date: Created at 18:11 2019/10/15.
 */
@Setter
@Getter
@Accessors(chain = true)
public class TableInfo {
    private Class<?> entityClass;
    private Field[] fields;
    private String tableName;
    /**
     * 主键列名
     */
    private String primaryKeyColumn;

    private String[] columns;

    private String[] selectColumns;

    public static class TIBuilder implements Builder<TableInfo> {
        private TableInfo tableInfo;

        public TIBuilder(Class<?> entityClass) {
            tableInfo = new TableInfo();
            tableInfo.setEntityClass(entityClass);
        }

        @Override
        public TableInfo build() {
            return tableInfo;
        }

        public TIBuilder fields(Field[] fields) {
            tableInfo.setFields(fields);
            return this;
        }

        public TIBuilder tableName(String tableName) {
            tableInfo.setTableName(tableName);
            return this;
        }

        public TIBuilder primaryKeyColumn(String primaryKeyColumn) {
            tableInfo.setPrimaryKeyColumn(primaryKeyColumn);
            return this;
        }

        public TIBuilder columns(String[] columns) {
            tableInfo.setColumns(columns);
            return this;
        }

        public TIBuilder selectColumns(String[] columns) {
            tableInfo.setSelectColumns(columns);
            return this;
        }

    }
}