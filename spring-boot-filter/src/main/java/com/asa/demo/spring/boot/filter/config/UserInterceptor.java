package com.asa.demo.spring.boot.filter.config;

import com.asa.demo.spring.boot.filter.bean.User;
import com.asa.demo.spring.boot.filter.service.IUserService;
import com.asa.demo.spring.boot.filter.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/6/30
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class UserInterceptor implements HandlerInterceptor {
    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User sessionUser = (User) request.getSession().getAttribute("user");
        // 已经登陆了，放行
        if (sessionUser != null) {
            return true;
        } else {
            //得到带过来cookie是否存在
            String loginToken = CookieUtil.findCookieByName(request, "loginToken");
            if (!StringUtils.isEmpty(loginToken)) {
                //到数据库查询有没有该Cookie
                User user = userService.findUserByLoginToken(loginToken);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                    return true;
                } else {
                    //没有该Cookie与之对应的用户(Cookie不匹配)
                    CookieUtil.clearCookie(request, response, "loginToken");
                    return false;
                }
            } else {

                //没有cookie、也没有登陆。是index请求获取用户信息，可以放行
                if (request.getRequestURI().contains("session")) {
                    return true;
                }

                //没有cookie凭证
                response.sendRedirect("/login.html");
                return false;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
