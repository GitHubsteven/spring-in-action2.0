package pers.asa.spring.api.mock.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/7/14
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
public class BaseDanniaoResponse implements Serializable {
    private boolean success;

    private String errorCode;

    private String errorMsg;
}
