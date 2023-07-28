package pers.asa.demo.spring.webflux.example.controller;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/18
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
public class WebFluxController {
    @GetMapping("/flux_result")
    public Mono<String> getResult(ServerHttpRequest request) {
        return Mono.defer(() -> Mono.just("result is ready!")).delaySubscription(Duration.ofMillis(500));
    }

    @GetMapping("/get-flux")
    public Flux<String> getFlux(ServerHttpRequest request) {
        return Flux.defer(() ->
                        Flux.just("result is ready!"))
                .delaySubscription(Duration.ofMillis(500));
    }
}
