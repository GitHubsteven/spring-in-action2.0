package com.asa.demo.mybatis.mysql.dao;

import com.asa.dem.spring.boot.vwe.bean.BlogTreeBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author asa.x
 * @since 2019-11-06
 */
@Mapper
public interface BlogDao {
    /**
     * 通过 id 查询博客相关
     *
     * @param blogIds 博客id集合
     * @return 博客相关信息
     */
    List<BlogTreeBean> getBlogDetail(@Param("blogIds") List<Integer> blogIds);

    /**
     * 通过 id 查询博客相关
     *
     * @param blogIds 博客id集合
     * @return 博客相关信息
     */
    List<BlogTreeBean> getBlogDetailSelect(@Param("blogIds") List<Integer> blogIds);
}
