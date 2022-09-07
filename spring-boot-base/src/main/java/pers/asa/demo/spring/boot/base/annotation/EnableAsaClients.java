package pers.asa.demo.spring.boot.base.annotation;

import org.springframework.context.annotation.Import;
import pers.asa.demo.spring.boot.base.register.AsaClientRegistrar;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(AsaClientRegistrar.class)
public @interface EnableAsaClients {
    String[] value() default {};

    String[] basePackages() default {};

    Class<?>[] basePackageClasses() default {};

    Class<?>[] defaultConfiguration() default {};

    Class<?>[] clients() default {};
}
