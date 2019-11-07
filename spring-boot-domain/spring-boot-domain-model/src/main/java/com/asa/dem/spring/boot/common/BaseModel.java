package com.asa.dem.spring.boot.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.time.LocalDateTime;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 18:29 2019/10/25.
 */
@Setter
@Getter
@Accessors(chain = true)
public class BaseModel<K> implements Serializable {
    @TableId(type = IdType.AUTO)
    private K id;
    private transient String creator;
    private transient String modifier;
    private transient LocalDateTime createTime;
    private transient LocalDateTime modifyTime;
}