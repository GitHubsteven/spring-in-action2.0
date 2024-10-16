package com.asa.demo.spring.aspect.config.filter;

import com.asa.demo.spring.aspect.bean.UserContext;
import com.asa.demo.spring.aspect.bean.UserContextThreadLocal;
import com.asa.demo.spring.aspect.core.Loggable;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @date: Created at 16:43 2019/9/20.
 */
@Component
public class UserContextFilter implements Filter, Loggable {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("---------- init UserContextFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        LOGGER.info("---------- doFilter UserContextFilter");
        RequestWrapper request = new RequestWrapper((HttpServletRequest) servletRequest);
        String requestBody = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        requestBody = requestBody.replaceAll("\\S", "");
        LOGGER.info("--------------request body is: {}", requestBody);
        String contextPath = request.getRequestURI();
        LOGGER.info("---------- doFilter UserContextFilter: start handle request:{}", contextPath);
        UserContextThreadLocal.set(new UserContext(contextPath));
        try {
            filterChain.doFilter(request, servletResponse);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
            LOGGER.info("exception will not handler ?????????????????????????????");
        }
        LOGGER.info("---------- doFilter UserContextFilter: end handle request:{} and set the userContext to null",
                contextPath);
        UserContextThreadLocal.remove();
        LOGGER.info("---------- doFilter UserContextFilter: the userContext is:{} after deleted",
                objectMapper.writeValueAsString(UserContextThreadLocal.get()));
    }

    @Override
    public void destroy() {
        LOGGER.info("---------- destroy UserContextFilter");
    }
}