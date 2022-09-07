package com.example.demo.model;

import org.springframework.context.annotation.Scope;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:05 2018/11/1.
 */
@Scope("session")
public class ControllerContext {
    private String sessionId;
}