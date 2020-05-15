package com.asa.demo.spring.aspect.config.aspect;

import com.asa.demo.spring.aspect.bean.AccessBean;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @date: Created at 16:56 2019/12/10.
 */
@Component
@Aspect
public class AccessAspect {
    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Pointcut(value = "execution(* com.asa.demo.spring.aspect.controller..*.*(*,javax.servlet.http.HttpServletRequest))")
    private void access() {

    }

    @Around("access()")
    public Object checkAccess(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around advice  start ....");
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Object target = pjp.getTarget();
        Method method = target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        Parameter[] parameters = method.getParameters();
        Object[] args = pjp.getArgs();
        if (args.length == 2) {
            HttpServletRequest servletRequests = (HttpServletRequest) args[1];
            String token = servletRequests.getHeader("token");
            String clientId = servletRequests.getHeader("clientId");
            AccessBean accessBean = (AccessBean) args[0];
            accessBean.setClientId(clientId).setToken(token);
            servletRequests.setAttribute("request_body", objectMapper.writeValueAsString(args[0]));
        }
        Object proceed = pjp.proceed();
        System.out.println("around advice  end ....");
        return proceed;
    }

    @Before("access()")
    public void setToken(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    }
}