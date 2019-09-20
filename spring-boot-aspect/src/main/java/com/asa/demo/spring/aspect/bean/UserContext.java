package com.asa.demo.spring.aspect.bean;

/**
 * 用户上下文信息
 * <p>
 * 可根据需要，追加其他上下文信息
 * </p>
 *
 * @author holysky.zhao 2016/12/30 15:15
 * @version 1.0.0 COPYRIGHT © 2001 - 2016 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 */
public class UserContext {
    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public UserContext(String loginName) {
        this.loginName = loginName;
    }
}
