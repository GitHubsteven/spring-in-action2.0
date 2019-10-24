package com.asa.demo.mybatis.mysql.solution1.support;

import com.google.common.base.CaseFormat;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 19:33 2019/10/23.
 */
public class StringUtils {
    public static String camel2Underscore(String val) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, val);
    }
}