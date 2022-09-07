/**
 * @author: asa.x
 * @date: 2022/9/7
 * @descrition:
 */
package com.asa.demo.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RoutingDataSource extends AbstractRoutingDataSource {
    private Logger logger = LogManager.getLogger();

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSource = RoutingDataSourceHolder.getDataSource();
        logger.info("使用数据源：{}", dataSource);
        return dataSource;
    }
}