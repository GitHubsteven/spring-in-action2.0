package com.asa.demo.mybatis.mysql.mapper;

import com.asa.demo.mybatis.mysql.model.BlogModel;
import com.asa.demo.mybatis.mysql.model.CountUser;
import com.asa.demo.mybatis.mysql.solution1.provider.BlogSqlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @date: Created at 9:45 2019/10/16.
 */
@Mapper
public interface BlogMapper extends BaseMapper<BlogModel> {
    @SelectProvider(type = BlogSqlProvider.class, method = "selectById")
//    @ResultMap("blogMap")
    BlogModel getById(@Param("id") long id);

    /**
     * 保存博客
     *
     * @param title  标题
     * @param author 作者
     * @return 数量
     */
    @InsertProvider(type = BlogSqlProvider.class, method = "insertBlog")
    int insertBlog(@Param("title") String title, @Param("author") String author);

    @SelectProvider(type = BlogSqlProvider.class, method = "countUserBlog")
    List<CountUser> listUserBlog();
}