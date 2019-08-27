package com.asa.demo.spring.cache.comon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 17:36 2019/8/27.
 */
public interface Loggable {
    Logger logger = LoggerFactory.getLogger(Loggable.class);
}