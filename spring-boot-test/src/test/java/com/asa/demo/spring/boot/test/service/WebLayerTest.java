package com.asa.demo.spring.boot.test.service;

import com.asa.demo.spring.boot.test.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:48 2019/8/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(HelloController.class)
public class WebLayerTest {
    @Autowired
    private MockMvc mockMvc;

    //throw a exception if there is no injected required bean.
    @MockBean
    private HelloService service;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/hi/home"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("home")));
    }
}