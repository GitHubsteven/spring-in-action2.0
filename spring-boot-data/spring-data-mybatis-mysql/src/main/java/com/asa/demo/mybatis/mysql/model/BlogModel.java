package com.asa.demo.mybatis.mysql.model;

import lombok.*;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 9:48 2019/10/16.
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BlogModel extends BaseModel<Long> {
    private Long id;
    private String title;
    private String author;
}