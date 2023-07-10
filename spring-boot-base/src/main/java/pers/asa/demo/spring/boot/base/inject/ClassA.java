/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.inject;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
@Component
public class ClassA implements InitializingBean {
    private ClassB classB;

    public ClassA(ClassB clasB) {
        this.classB = clasB;
    }


    @Override
    public void afterPropertiesSet() throws Exception {

    }

    public String getClassHash() {
        return String.format("classB hashcode: %s" , classB.hashCode());
    }
}
