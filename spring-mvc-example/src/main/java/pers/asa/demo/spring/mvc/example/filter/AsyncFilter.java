package pers.asa.demo.spring.mvc.example.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/18
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Component
public class AsyncFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        // sleep for 200ms
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException("thread sleep 200 ms failed", e);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
