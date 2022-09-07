/**
 * @author: asa.x
 * @date: 2022/9/7
 * @descrition:
 */
package com.asa.demo.aop;

import com.asa.demo.annotation.DataSourceWith;
import com.asa.demo.config.DataSourceConfigurer;
import com.asa.demo.config.RoutingDataSourceHolder;
import org.apache.commons.lang3.RandomUtils;
import org.apache.ibatis.annotations.Select;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Aspect
@Order(-1)// 保证该AOP在@Transactional之前运行
@Component
public class DataSourceWithAspect {
    public static List<String> SELECT_SQL_KEYS = Arrays.asList("select", "find", "list", "get");

    /**
     * 使用DataSourceWith注解就拦截
     */
    @Pointcut("@annotation(com.asa.demo.annotation.DataSourceWith)" + "||@within(com.asa.demo.annotation.DataSourceWith)" + "||execution(* com.asa.demo.dao.*.*(..))")
    public void doPointcut() {

    }

    /**
     * 方法前，为了在事务前设置
     */
    @Before("doPointcut()")
    public void doBefore(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        // 获取注解对象
        DataSourceWith dataSource = method.getAnnotation(DataSourceWith.class);
        if (dataSource == null) {
            //方法没有就获取类上的
            dataSource = method.getDeclaringClass().getAnnotation(DataSourceWith.class);
        }
        String key = dataSource != null ? dataSource.key() : defaultKey(method);
        RoutingDataSourceHolder.setDataSource(key);
    }

    /**
     * 判断是否为select，这中方式不会对业务很大的侵入，但是需要规范查询的命名，但是是值得的
     *
     * @param method 方法
     * @return 方法决定的默认库
     */
    public String defaultKey(Method method) {
        Select selectAnn = method.getAnnotation(Select.class);
        boolean isSelect = selectAnn != null;
        if (!isSelect) {
            String name = method.getName();
            for (String selectSqlKey : SELECT_SQL_KEYS) {
                if (name.contains(selectSqlKey)) {
                    isSelect = true;
                    break;
                }
            }
        }
        // 如果是查询的话，那么默认从多个从库中随机获取，策略自己定义，也可以通过redis来缓存查询每个库的访问次数，测错看需求
        if (isSelect) {
            int random = RandomUtils.nextInt(0, 2);
            return random % 2 == 0 ? DataSourceConfigurer.SLAVE_DATASOURCE2 : DataSourceConfigurer.SLAVE_DATASOURCE;
        }
        return DataSourceConfigurer.MASTER_DATASOURCE;
    }

    @After("doPointcut()")
    public void doAfter(JoinPoint joinPoint) {
        RoutingDataSourceHolder.clearDataSource();
    }

}