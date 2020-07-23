package com.asa.demo.spring.security.jwt.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @Authoer: asa.x
 * @Date: 2020/7/23
 * @Descrition:
 */
public class MyRealm implements Realm {
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
