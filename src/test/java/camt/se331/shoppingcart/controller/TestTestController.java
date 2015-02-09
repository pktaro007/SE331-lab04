package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.config.AppConfig;
import camt.se331.shoppingcart.config.WebAppInitializer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Created by Dto on 2/7/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, WebAppInitializer.class})
@WebAppConfiguration
public class TestTestController {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Before
    public void setUp(){

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void getText() throws Exception{

        MvcResult result = mockMvc.perform(post("/temp").content("abc"))
                .andExpect(status().isOk())
                .andDo(print()).andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);

    }
}
