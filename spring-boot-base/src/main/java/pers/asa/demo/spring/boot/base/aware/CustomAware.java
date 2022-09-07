package pers.asa.demo.spring.boot.base.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import pers.asa.demo.spring.boot.base.util.ApplicationContextUtil;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/4/28 10:50
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/4/28 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Component
public class CustomAware implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.setApplicationContext(applicationContext);
    }
}

