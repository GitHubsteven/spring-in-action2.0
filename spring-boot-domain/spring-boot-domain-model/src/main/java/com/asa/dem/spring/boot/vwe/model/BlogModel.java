package com.asa.dem.spring.boot.vwe.model;

import com.asa.dem.spring.boot.common.BaseModel;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author asa.x
 * @since 2019-10-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("vwe_blog")
public class BlogModel extends BaseModel<Integer> {

    private static final long serialVersionUID = 1L;

    private String title;

    private String author;

}
