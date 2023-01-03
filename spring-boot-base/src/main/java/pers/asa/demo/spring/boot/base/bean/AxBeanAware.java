/**
 * @author: asx
 * @date: 2022/11/28
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.Lifecycle;

import java.util.Date;

public class AxBeanAware implements BeanNameAware, Lifecycle {

    private String name;

    private Date start;

    private Date end;

    public AxBeanAware(String name) {
        this.name = name;
    }

    @Override
    public void setBeanName(String name) {
        setBeanName(name);
    }

    @Override
    public void start() {
        this.start = new Date();
        System.out.printf("bean name: %s, at time %d", name, System.currentTimeMillis());
    }



    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
