package com.asa.demo.sharding.service.impl;

import com.asa.demo.sharding.domain.BtConfigModel;
import com.asa.demo.sharding.mapper.BtConfigMapper;
import com.asa.demo.sharding.service.BtConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author xrb16
 * @description 针对表【t_config】的数据库操作Service实现
 * @createDate 2022-10-14 15:50:47
 */
@Service
public class BtConfigServiceImpl extends ServiceImpl<BtConfigMapper, BtConfigModel> implements BtConfigService {

}
