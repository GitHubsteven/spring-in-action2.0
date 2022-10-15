/**
 * @author: asx
 * @date: 2022/10/15
 * @descrition:
 */
package com.asa.demo.sharding.mapper;

import com.asa.demo.sharding.ShardingAppTest;
import com.asa.demo.sharding.domain.BtConfigModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Slf4j
public class BtConfigMapperTest extends ShardingAppTest {
    @Autowired
    private BtConfigMapper btConfigMapper;


    @Test
    public void testBroadcastConfig() {
        BtConfigModel config = new BtConfigModel();
        config.setRemark("test config");
        config.setCreateTime(new Date());
        config.setLastModifyTime(new Date());
        btConfigMapper.insert(config);
        log.debug("config id is: " + config.getId());
    }
}
