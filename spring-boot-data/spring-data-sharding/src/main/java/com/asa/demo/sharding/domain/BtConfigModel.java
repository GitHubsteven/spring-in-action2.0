package com.asa.demo.sharding.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName t_config
 */
@Data
public class BtConfigModel implements Serializable {
    /**
     * 
     */
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