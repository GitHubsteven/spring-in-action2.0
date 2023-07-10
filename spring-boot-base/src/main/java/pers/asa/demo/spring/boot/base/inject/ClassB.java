/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.inject;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
@Component
public class ClassB {
    private final ClassA classA;

    @Lazy
    public ClassB(ClassA classA) {
        this.classA = classA;
    }


    public String classHashCode() {
        return String.format("classA hashcode: %s", classA.hashCode());
    }
}
