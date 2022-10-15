package com.asa.demo.sharding.service.impl;

import com.asa.demo.sharding.domain.BtOrderModel;
import com.asa.demo.sharding.mapper.BtOrderMapper;
import com.asa.demo.sharding.service.BtOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author xrb16
 * @description 针对表【t_order_0】的数据库操作Service实现
 * @createDate 2022-10-14 15:42:29
 */
@Service
public class BtOrderServiceImpl extends ServiceImpl<BtOrderMapper, BtOrderModel> implements BtOrderService {

}
