package com.asa.demo.sharding.mapper;

import com.asa.demo.sharding.domain.BtOrderModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xrb16
 * @description 针对表【t_order_0】的数据库操作Mapper
 * @createDate 2022-10-14 15:42:29
 * @Entity com.asa.demo.sharding.domain.Order0
 */
public interface BtOrderMapper extends BaseMapper<BtOrderModel> {

    List<BtOrderModel> selectByCreateName(IPage<BtOrderModel> pageBean,
                                          @Param("createName") String createName);
}
