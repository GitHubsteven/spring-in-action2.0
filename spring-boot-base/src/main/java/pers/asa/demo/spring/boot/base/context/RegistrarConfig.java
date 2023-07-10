/**
 * @author: asx
 * @date: 2023/7/10
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.context;

import org.springframework.context.annotation.Import;
import pers.asa.demo.spring.boot.base.register.AxBeanRegistrar;

/**
 * @author: asx
 * @date: 2023/7/10
 * @descrition:
 */
@Import(AxBeanRegistrar.class)
public class RegistrarConfig {
}
