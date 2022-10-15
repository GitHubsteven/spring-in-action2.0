package com.asa.demo.sharding.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName t_config
 */
@Data
@TableName("t_config")
public class BtConfigModel implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     *
     */
    private String remark;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date lastModifyTime;

    private static final long serialVersionUID = 1L;
}