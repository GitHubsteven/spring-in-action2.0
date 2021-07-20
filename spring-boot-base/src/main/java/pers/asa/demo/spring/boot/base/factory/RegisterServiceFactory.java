package pers.asa.demo.spring.boot.base.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/20 17:34
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/20 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class RegisterServiceFactory implements FactoryBean<RegisterService> {

    private final Integer id;

    public RegisterServiceFactory(Integer id) {
        this.id = id;
    }

    @Override
    public RegisterService getObject() throws Exception {
        return new RegisterService(id);
    }

    @Override
    public Class<?> getObjectType() {
        return RegisterService.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}

