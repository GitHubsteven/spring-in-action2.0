package com.asa.demo.spring.aspect.config.aspect;

import com.asa.demo.spring.aspect.bean.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author: rongbin.xie
 * @email: xierongbin@chinalife-p.com.cn
 * @date: 2023/9/24
 */

/**
 * 全局统一返回结果类and异常处理类
 */
@RestControllerAdvice(basePackages = "com.atguigu.ssyx.controller")
public class AxResponseAspect implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        //获取控制器名称
        String name = Objects.requireNonNull(methodParameter.getMethod()).getName();
        List<String> list = Arrays.asList(name);
        return !list.contains(name);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return Result.ok(o);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public Result<String> businessValidate(Exception e) {
        e.printStackTrace();
        return Result.fail(null);
    }
}
