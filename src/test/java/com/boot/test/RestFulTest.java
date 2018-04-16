package com.boot.test;

import com.boot.Appliction.HelloApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * resutful接口测试
 *
 * @author yanling
 * @time 2018-03-05-9:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MockServletContext.class})
@WebAppConfiguration
public class RestFulTest extends MockMvcResultMatchers{
    private MockMvc mockMvc;

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloApplication()).build();
    }


    @Test
    public void get() throws Exception {
        RequestBuilder request  = MockMvcRequestBuilders.get("/ling/yan/queryAllUser");

        mockMvc.perform(request).andExpect(status().isOk());

    }
}
