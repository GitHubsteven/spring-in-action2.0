package com.asa.dem.spring.boot.vwe.dao;

import com.asa.dem.spring.boot.vwe.bean.BlogTreeBean;
import com.asa.dem.spring.boot.vwe.model.BlogModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author asa.x
 * @since 2019-11-06
 */
@Repository
public interface BlogDao extends BaseMapper<BlogModel> {
    /**
     * 通过 id 查询博客相关
     *
     * @param blogId 博客id
     * @return 博客相关信息
     */
    BlogTreeBean blogTree(@Param("blogId") int blogId);
}
