package com.asa.demo.mybatis.mysql.solution1.provider;

import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @date: Created at 9:51 2019/10/16.
 */
public class BlogSqlProvider {
    public String selectById(Map<String, Object> parameters) {
        return "select * from spring_boot.vwe_blog where id =" + parameters.get("id");
    }

    public String insertBlog(Map<String, Object> parameters) {
        return String.format("insert into spring_boot.vwe_blog(title,author) values('%s','%s')",
                parameters.get("title"), parameters.get("author"));
    }

    public String countUserBlog(Map<String, Object> parameters) {
        return "SELECT\n" +
                "  u.name,\n" +
                "  count(1) AS count\n" +
                "FROM spring_boot.user u\n" +
                "  INNER JOIN spring_boot.vwe_blog b\n" +
                "    ON u.name = b.author\n" +
                "GROUP BY u.name";
    }
}