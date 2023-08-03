/**
 * @author: asx
 * @date: 2023/7/31
 * @descrition:
 */
package com.asa.demo.sharding.config;

import com.asa.demo.sharding.util.DateUtils;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

/**
 * @author: asx
 * @date: 2023/7/31
 * @descrition: 分表对则
 */
//@Component
public class AXPreciseAlgorithmClassName implements PreciseShardingAlgorithm<Date> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Date> shardingValue) {
        //配置的分片的sharding-column对应的值
        Date timeValue = shardingValue.getValue();
        String time = DateUtils.dateTieToString(timeValue, "yyyy-MM-dd HH:mm:ss");

        //分库时配置的sharding-column
        String timeColumn = shardingValue.getColumnName();
        //需要分库的逻辑表
        String tableName = shardingValue.getLogicTableName();

        //按月份路由
        LocalDateTime localDateTime = DateUtils.asLocalDateTime(timeValue);
        int year = localDateTime.getYear();
        int monthValue = localDateTime.getMonthValue();
        int quarter = DateUtils.getQuarter(monthValue);

        for (String each : availableTargetNames) {
            if (each.endsWith(year + "_" + quarter)) {
                return each;
            }
        }
        throw new IllegalArgumentException("cant get table route!");

    }
}
