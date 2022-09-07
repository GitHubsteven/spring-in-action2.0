package com.asa.dem.spring.boot.vwe.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.asa.dem.spring.boot.common.BaseModel;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author asa.x
 * @since 2019-10-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("session")
public class SessionModel extends BaseModel<Integer> {

    private static final long serialVersionUID = 1L;

    @TableField("sesssionId")
    private String sesssionId;

    private String remark;


}
