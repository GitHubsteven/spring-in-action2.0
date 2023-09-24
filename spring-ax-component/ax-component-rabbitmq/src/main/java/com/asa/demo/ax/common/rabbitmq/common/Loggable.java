/**
 * @author: asx
 * @date: 2023/1/3
 * @descrition:
 */
package com.asa.demo.ax.common.rabbitmq.common;

import java.util.logging.Logger;

public abstract class Loggable {
    public Logger logger = Logger.getLogger(this.getClass().getName());
}
