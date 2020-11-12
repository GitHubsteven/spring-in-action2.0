package pers.asa.demo.spring.service.center.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/31
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
@ToString
public class SyncDataModel {

    private String syncMethod;

    private String dataJson;

    private String platform;
}
