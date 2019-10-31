package com.asa.dem.spring.boot.vwe.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 18:07 2019/10/31.
 */
public class BaseService<D extends BaseMapper<M>, M> extends ServiceImpl<D, M> {
}