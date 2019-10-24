package com.baomidou.ant.vwe.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.ant.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author asa.x
 * @since 2019-10-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("vwe_blog")
public class Blog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String title;

    private String author;


}
