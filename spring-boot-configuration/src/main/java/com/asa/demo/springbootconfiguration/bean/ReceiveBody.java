package com.asa.demo.springbootconfiguration.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author asa.x
 * @Date: Created at 12:08 2020/3/6.
 */
@Setter
@Getter
public class ReceiveBody implements Serializable {
    private List<String> names;
}