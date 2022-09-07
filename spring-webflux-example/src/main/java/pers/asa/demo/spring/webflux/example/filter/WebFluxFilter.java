package pers.asa.demo.spring.webflux.example.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/18
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Component
public class WebFluxFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        return Mono.delay(Duration.ofMillis(200)).then(webFilterChain.filter(serverWebExchange));
    }
}
