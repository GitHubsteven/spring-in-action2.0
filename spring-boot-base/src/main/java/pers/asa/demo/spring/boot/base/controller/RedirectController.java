package pers.asa.demo.spring.boot.base.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author: rongbin.xie
 * @email: xierongbin@chinalife-p.com.cn
 * @date: 2024/6/24
 * @description:
 */
@RestController
@RequestMapping("/redirect-test")
public class RedirectController {
    @RequestMapping("alipayforward")
    public ModelAndView alipayforward(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String contNo = req.getParameter("contNo");
        String url = "redirect:http://baidu.com";
        return new ModelAndView(url);
    }

    @RequestMapping("alipayforward/{contNo}")
    public void alipayforward(@PathVariable("contNo") String contNo, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //String contNo =req.getParameter("contNo"); //保单号
        resp.sendRedirect("http://baidu.com");
    }

    @RequestMapping("/red")
    public void red(HttpServletResponse resp) throws Exception {
        //String contNo =req.getParameter("contNo"); //保单号
        resp.sendRedirect("http://baidu.com");
    }

    @RequestMapping(params = "action=alipayforward")
    public String alipayforward(Map modelMap){
        modelMap.put("userName", "呵呵");
        modelMap.put("password", "123456");
        modelMap.put("age", "25");
        return "redirect:http://localhost:8088/era/user/alipayforward4?modelMap="+modelMap;
    }
}
