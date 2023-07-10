/**
 * @author: asx
 * @date: 2022/11/28
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.bean;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.Lifecycle;

/**
 * 运行的监控
 */
public class AXLifeMonitor implements BeanPostProcessor, Lifecycle {
    @Override
    public void start() {
        System.out.println("start the ax life monitor");
    }

    @Override
    public void stop() {
        System.out.println("stop the ax life monitor");
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
