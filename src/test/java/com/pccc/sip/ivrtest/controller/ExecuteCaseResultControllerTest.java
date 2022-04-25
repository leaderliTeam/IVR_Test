package com.pccc.sip.ivrtest.controller;

import com.pccc.sip.ivrtest.util.GsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExecuteCaseResultControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(ExecuteCaseControllerTest.class);

    @Autowired
    MockMvc mockMvc;

    @Test
    public void query() throws Exception {

        mockMvc.perform(post("/executeCaseResult/query")
                .contentType(MediaType.APPLICATION_JSON)
                .content(GsonUtil.GsonString(GsonUtil.readerJsonObject("json/executeCaseResult/query.json")))
                .accept(MediaType.APPLICATION_JSON)).andExpect(result -> {
            logger.info(" 返回报文 -> " + result.getResponse().getContentAsString());
        });

    }

}
