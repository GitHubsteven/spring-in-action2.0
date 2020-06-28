package com.asa.demo.spring.boot.security.config;

import com.asa.demo.spring.boot.security.bean.SecurityAuthenticationEntryPoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author: asaland
 * @date: 2019/8/31
 * @time: 14:07
 * @version: 1.0.0
 * @description:
 **/
@Configuration
@EnableWebSecurity    // enable for the web security
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //define the roles
        auth.inMemoryAuthentication()
                .withUser("asa.x")
                .password(bCryptPasswordEncoder.encode("123456"))
                .roles("user")
                .and()
                .withUser("admin")
                .password(bCryptPasswordEncoder.encode("admin123"))
                .roles("USER", "ADMIN")
                .and()
                .passwordEncoder(bCryptPasswordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/authentication")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new SecurityAuthenticationEntryPoint());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**").antMatchers("/js/**");
        super.configure(web);
    }
}
