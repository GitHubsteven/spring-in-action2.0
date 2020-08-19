package com.example.demo.controller;

import com.example.demo.model.ContextMessage;
import com.example.demo.model.JsonObj;
import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 用来测试spring的多线程
 * @Date: Created at 15:52 2018/11/1.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/bus1")
    public JsonObj bus1(@RequestBody Map<String, Object> params) {
        ContextMessage ctx = recordContext(params);
        JsonObj result = new JsonObj(null);
        result.setContext(ctx);
        return result;
    }


    @RequestMapping("/getName")
    public JsonObj getName(@RequestBody Map<String, Object> params) {
        String name = (String) params.get("name");
        //业务代码
        helloService.setUser(name);
        try {
            //线程休息2s
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("InterruptedException", e);
        }
        return success("name:" + helloService.getUser(), params);
    }

    private JsonObj success(Object data, Object param) {
        JsonObj result = new JsonObj(data);
        result.setResult("T");
        result.setMessage("success");
        result.setContext(recordContext(param));
        return result;
    }


    /**
     * 生成上下文信息
     *
     * @param params 请求参数
     * @return 上下文信息
     */
    private ContextMessage recordContext(Object params) {
        ContextMessage ctx = new ContextMessage();
        ctx.setRequestParams(params);
        ctx.setServiceAddress(helloService.toString());
        ctx.setThreadName(Thread.currentThread().getName());
        ctx.setControllerAddr(this.toString());
        return ctx;
    }

}