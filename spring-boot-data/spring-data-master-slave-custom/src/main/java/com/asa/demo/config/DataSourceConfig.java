/**
 * @author: asa.x
 * @date: 2022/9/7
 * @descrition:
 */
package com.asa.demo.config;

import com.dangdang.ddframe.rdb.sharding.api.MasterSlaveDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.strategy.slave.MasterSlaveLoadBalanceStrategyType;
import com.dangdang.ddframe.rdb.sharding.keygen.DefaultKeyGenerator;
import com.dangdang.ddframe.rdb.sharding.keygen.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {
    private final Database0Config database0Config;

    private final Database1Config database1Config;

    private final Database2Config database2Config;

    public DataSourceConfig(Database0Config database0Config, Database1Config database1Config, Database2Config database2Config) {
        this.database0Config = database0Config;
        this.database1Config = database1Config;
        this.database2Config = database2Config;
    }

    private DataSource buildDataSource() throws SQLException {
        //设置从库数据源集合
        Map<String, DataSource> slaveDataSourceMap = new HashMap<>();
        slaveDataSourceMap.put(database1Config.getDatabaseName(), database1Config.createDataSource());
        slaveDataSourceMap.put(database2Config.getDatabaseName(), database2Config.createDataSource());

        //获取数据源对象
        return MasterSlaveDataSourceFactory.createDataSource("masterSlave", database0Config.getDatabaseName(), database0Config.createDataSource(), slaveDataSourceMap, MasterSlaveLoadBalanceStrategyType.getDefaultStrategyType());
    }


    @Bean
    public DataSource getDataSource() throws SQLException {
        return buildDataSource();
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return new DefaultKeyGenerator();
    }


}
