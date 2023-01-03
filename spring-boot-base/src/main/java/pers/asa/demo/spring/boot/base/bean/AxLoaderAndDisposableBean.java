/**
 * @author: asx
 * @date: 2022/11/28
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.bean;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AxLoaderAndDisposableBean implements BeanClassLoaderAware, InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {

    }


    @PostConstruct
    public void init() {

    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {

    }

    @Override
    public void destroy() throws Exception {

    }

    @PreDestroy
    public void destroy1() {

    }
}
