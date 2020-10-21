package com.asa.dem.spring.boot.vwe.model;

import com.asa.dem.spring.boot.common.BaseModel;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

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
@TableName("vwe_comments")
public class CommentsModel extends BaseModel<Integer> {

    private static final long serialVersionUID = 1L;

    private long blogId;

    private String remark;

    private List<TagModel> tags;
}
