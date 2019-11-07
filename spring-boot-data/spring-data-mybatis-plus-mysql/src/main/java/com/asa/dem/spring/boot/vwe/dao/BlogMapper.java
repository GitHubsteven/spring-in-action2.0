package com.asa.dem.spring.boot.vwe.dao;

import com.asa.dem.spring.boot.vwe.model.BlogModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author asa.x
 * @since 2019-10-31
 */
@Component
public interface BlogMapper extends BaseMapper<BlogModel> {
    int count();
}
