package com.asa.demo.spring.aspect.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:49 2019/9/20.
 */
public interface Loggable {
    Logger LOGGER = LoggerFactory.getLogger(Loggable.class);
}