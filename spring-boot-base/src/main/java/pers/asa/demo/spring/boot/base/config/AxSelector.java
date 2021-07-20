package pers.asa.demo.spring.boot.base.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import pers.asa.demo.spring.boot.base.service.DemoService;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/20 15:42
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/20 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class AxSelector implements ImportSelector, EnvironmentAware {
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        final String property = environment.getProperty("ax.selector");
        if ("book".equalsIgnoreCase(property)) {
            return new String[]{AxBookSelector.class.getName()};
        } else if ("paper".equalsIgnoreCase(property)) {
            return new String[]{AxPaperSelector.class.getName()};
        } else {
            throw new IllegalArgumentException(String.format("not support ax.selector:[%s]", property));
        }
    }

    public static class AxSelectService implements DemoService {
        private String name;

        public AxSelectService(String name) {
            this.name = name;
        }

        @Override
        public void demo() {
            System.out.printf("ax selector service: %s ...%n", name);
        }
    }

    public static class AxBookSelector extends AxSelectService {
        public AxBookSelector() {
            super("book");
        }
    }

    public static class AxPaperSelector extends AxSelectService {
        public AxPaperSelector() {
            super("paper");
        }
    }
}

