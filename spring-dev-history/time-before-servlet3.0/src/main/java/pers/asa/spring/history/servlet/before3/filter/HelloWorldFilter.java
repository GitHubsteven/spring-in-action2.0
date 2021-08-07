package pers.asa.spring.history.servlet.before3.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/8/5 15:34
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/8/5 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class HelloWorldFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("触发 Hello World 过滤器...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

