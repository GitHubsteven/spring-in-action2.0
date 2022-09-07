package com.example.demo.service.notservice;

import com.example.demo.model.UserContext;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 17:02 2018/11/8.
 */
public class GetService {
    public static void main(String[] args) {
        UserContext context = new UserContext();
        context.setName("parent");

        UserContext two = new UserContext();
        two.setName("two");
        context.setSubUser(two);

        UserContext sub = context.getSubUser();
        sub = null;
        System.out.println("sub outside:" + (sub == null ? null : sub.getName()));
        System.out.println("sub inside:" + (context.getSubUser() == null ? null : context.getSubUser().getName()));
    }
}