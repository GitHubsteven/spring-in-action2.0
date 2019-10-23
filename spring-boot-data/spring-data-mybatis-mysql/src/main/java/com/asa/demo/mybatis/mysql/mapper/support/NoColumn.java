package com.asa.demo.mybatis.mysql.mapper.support;

import lombok.Setter;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
public @interface NoColumn {
}
