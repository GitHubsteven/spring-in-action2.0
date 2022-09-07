/**
 * @author: asa.x
 * @date: 2022/9/7
 * @descrition:
 */
package com.asa.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置主从数据库
 */
@Configuration
public class DataSourceConfigurer {
    private Logger logger = LogManager.getLogger();

    public final static String MASTER_DATASOURCE = "masterDataSource";
    public final static String SLAVE_DATASOURCE = "slaveDataSource";

    public final static String SLAVE_DATASOURCE2 = "slaveDataSource2";

    @Bean(MASTER_DATASOURCE)
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource masterDataSource(DataSourceProperties properties) {
        DruidDataSource build = properties.initializeDataSourceBuilder().type(DruidDataSource.class).build();
        logger.info("配置主数据库:{}", build);
        return build;
    }

    @Bean(SLAVE_DATASOURCE)
    @ConfigurationProperties(prefix = "spring.slave-datasource")
    public DruidDataSource slaveDataSource(DataSourceProperties properties) {
        DruidDataSource build = properties.initializeDataSourceBuilder().type(DruidDataSource.class).build();
        logger.info("配置从数据库:{}", build);
        return build;
    }

    @Bean(SLAVE_DATASOURCE2)
    @ConfigurationProperties(prefix = "spring.slave2-datasource")
    public DruidDataSource slaveDataSource2(DataSourceProperties properties) {
        DruidDataSource build = properties.initializeDataSourceBuilder().type(DruidDataSource.class).build();
        logger.info("配置从数据库:{}", build);
        return build;
    }

    /**
     * Primary 优先使用该Bean
     * DependsOn 先执行主从数据库的配置
     * Qualifier 指定使用哪个Bean
     *
     * @param masterDataSource
     * @param slaveDataSource
     * @return
     */
    @Bean
    @Primary
    @DependsOn(value = {MASTER_DATASOURCE, SLAVE_DATASOURCE, SLAVE_DATASOURCE2})
    public DataSource routingDataSource(@Qualifier(MASTER_DATASOURCE) DruidDataSource masterDataSource,
                                        @Qualifier(SLAVE_DATASOURCE) DruidDataSource slaveDataSource,
                                        @Qualifier(SLAVE_DATASOURCE2) DruidDataSource slaveDataSource2) {
        if (StringUtils.isBlank(slaveDataSource.getUrl())) {
            logger.info("没有配置从数据库,默认使用主数据库");
            return masterDataSource;
        }
        Map<Object, Object> map = new HashMap<>(2);
        map.put(DataSourceConfigurer.MASTER_DATASOURCE, masterDataSource);
        map.put(DataSourceConfigurer.SLAVE_DATASOURCE, slaveDataSource);
        map.put(DataSourceConfigurer.SLAVE_DATASOURCE2, slaveDataSource2);
        RoutingDataSource routing = new RoutingDataSource();
        //设置动态数据源
        routing.setTargetDataSources(map);
        //设置默认数据源
        routing.setDefaultTargetDataSource(masterDataSource);
        logger.info("主从数据库配置完成");
        return routing;
    }
}