package com.asa.demo.mybatis.mysql.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 11:13 2019/11/1.
 */
@Setter
@Getter
public class SessionModel extends BaseModel<Long> {
    private String sessionId;
    private String remark;
}