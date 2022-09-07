package com.asa.demo.spring.security.jwt.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/24
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class UsernameAndPasswordRealm implements Realm {
    @Override
    public String getName() {
        return "MyRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = (String) usernamePasswordToken.getPrincipal();
        String password = (String) usernamePasswordToken.getCredentials();
        if (!"zhang".equalsIgnoreCase(username)) {
            throw new UnknownAccountException();
        }
        if (!"123".equalsIgnoreCase(password)) {
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
