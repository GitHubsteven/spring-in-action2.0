/**
 * @author: asa.x
 * @date: 2022/9/7
 * @descrition:
 */
package com.asa.demo.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RoutingDataSourceHolder {
    private static Logger logger = LogManager.getLogger();

    private static final ThreadLocal<String> dataSources = new ThreadLocal<>();

    /**
     * 一个事务内用同一个数据源
     */
    public static void setDataSource(String dataSourceName) {
        if (dataSources.get() == null) {
            dataSources.set(dataSourceName);
            logger.info("thread:{} 设置数据源：{}", Thread.currentThread().getName(), dataSourceName);
        }
    }

    public static String getDataSource() {
        return dataSources.get();
    }

    public static void clearDataSource() {
        dataSources.remove();
    }
}