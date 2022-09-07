### 项目说明

名称 | 说明
---|---
spring-api-order | 订单服务，带有security+jwt安全认证
row 2 col 1 | row 2 col 2

#### spring-api-order
##### Security
1. 身份认证
    ```
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().withUser("zhangsan")
                    .password("{noop}123456")
                    .roles("USER")
                    .and()
                    .withUser("admin")
                    .password("{noop}admin")    //security5.x 需要这个格式
                    .roles("USER", "ADMIN");
        }
    ```
2. 权限验证
    ```
     http.csrf().disable()
                    .authorizeRequests()
                    // antMatchers的命名来源于Java早期的一个构建工具Ant
                    .antMatchers(HttpMethod.DELETE, "/service/product/**")
                    .hasRole("ADMIN")
                    .anyRequest()
                    .authenticated()
                    .and()
                    .httpBasic();
    ```