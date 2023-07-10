/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.jms;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
@Component
public class AxMessageBean implements InitializingBean {

    @PostConstruct
    public void init() {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("AxMessage  afterPropertiesSet...");
    }

    public String messageName(){
        return "ax-message-body";
    }
}
