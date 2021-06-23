package pers.asa.demo.spring.boot.base.util;

import org.springframework.context.ApplicationContext;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/4/28 10:54
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/4/28 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class ApplicationContextUtil {
    /**
     * ApplicationContext对象，会ApplicationContextAwareImpl中的setApplicationContext方法中赋值
     */
    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    /**
     * 根据类型获取指定的bean
     * @param requiredType Class
     * @param <T> 泛型
     * @return
     */
    public static <T> T getBean(Class<T> requiredType ){
        return applicationContext.getBean(requiredType);
    }

    /**
     * 根据名称和类型获取Bean
     * @param name bean的id
     * @param requiredType class
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name,Class<T> requiredType){
        return applicationContext.getBean(name,requiredType);
    }
}

