package pers.asa.spring.history.servlet.before3.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/8/5 15:33
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/8/5 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter writer = response.getWriter();
        writer.println("Hello World");
    }
}

