/**
 * @author: asx
 * @date: 2022/11/28
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.context;

import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.core.StandardContext;

public class MyApplicationContext extends ApplicationContext {

    public MyApplicationContext(StandardContext context) {
        super(context);
    }
}
