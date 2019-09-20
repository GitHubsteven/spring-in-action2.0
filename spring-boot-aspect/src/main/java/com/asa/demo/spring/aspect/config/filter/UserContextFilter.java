package com.asa.demo.spring.aspect.config.filter;

import com.asa.demo.spring.aspect.bean.UserContext;
import com.asa.demo.spring.aspect.bean.UserContextThreadLocal;
import com.asa.demo.spring.aspect.core.Loggable;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:43 2019/9/20.
 */
@Component
public class UserContextFilter implements Filter, Loggable {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("==================== init UserContextFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        LOGGER.info("==================== doFilter UserContextFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String contextPath = request.getRequestURI();
        LOGGER.info("==================== doFilter UserContextFilter: start handle request:{}", contextPath);
        UserContextThreadLocal.set(new UserContext(contextPath));
        filterChain.doFilter(servletRequest, servletResponse);
        LOGGER.info("==================== doFilter UserContextFilter: end handle request:{} and set the userContext to null",
                contextPath);
        UserContextThreadLocal.set(null);
        LOGGER.info("==================== doFilter UserContextFilter: the userContext is:{} after deleted",
                objectMapper.writeValueAsString(UserContextThreadLocal.get()));
    }

    @Override
    public void destroy() {
        LOGGER.info("==================== destroy UserContextFilter");
    }
}