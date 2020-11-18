package pers.asa.demo.spring.mvc.example.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/18
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
public class AsyncController {
    @GetMapping("/async_result")
    @Async
    public CompletableFuture<String> geResultAsync(HttpServletRequest request) throws InterruptedException {
        Thread.sleep(500);
        return CompletableFuture.completedFuture("result is ready!");
    }
}
