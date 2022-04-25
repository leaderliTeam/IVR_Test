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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExecuteCaseControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(ExecuteCaseControllerTest.class);

    @Autowired
    MockMvc mockMvc;

    @Test
    public void executeCases() throws Exception {

        mockMvc.perform(post("/executeCase/execute")
        .contentType(MediaType.APPLICATION_JSON)
        .content(GsonUtil.readerArrayJson("json/executeCase/execute.json"))
        .accept(MediaType.APPLICATION_JSON)).andExpect(result -> {
            logger.info(" 返回报文 -> " + result.getResponse().getContentAsString());
        });

    }

    @Test
    public void addData() throws Exception {

        mockMvc.perform(post("/executeCase/addData")
                .contentType(MediaType.APPLICATION_JSON)
                .content(GsonUtil.GsonString(GsonUtil.readerJsonObject("json/executeCase/addData.json")))
                .accept(MediaType.APPLICATION_JSON)).andExpect(result -> {
            logger.info(" 返回报文 -> " + result.getResponse().getContentAsString());
        });

    }

    @Test
    public void queryId() throws Exception {

        mockMvc.perform(get("/executeCase/queryId").param("queryType","E")).andExpect(result -> {
            logger.info(" 返回报文 -> " + result.getResponse().getContentAsString());
        });

    }

    @Test
    public void add() throws Exception {

        mockMvc.perform(post("/executeCase/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(GsonUtil.GsonString(GsonUtil.readerJsonObject("json/executeCase/add.json")))
                .accept(MediaType.APPLICATION_JSON)).andExpect(result -> {
            logger.info(" 返回报文 -> " + result.getResponse().getContentAsString());
        });

    }

    @Test
    public void query() throws Exception {

        mockMvc.perform(post("/executeCase/query")
                .contentType(MediaType.APPLICATION_JSON)
                .content(GsonUtil.GsonString(GsonUtil.readerJsonObject("json/executeCase/query.json")))
                .accept(MediaType.APPLICATION_JSON)).andExpect(result -> {
            logger.info(" 返回报文 -> " + result.getResponse().getContentAsString());
        });

    }

    @Test
    public void update() throws Exception {

        mockMvc.perform(post("/executeCase/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(GsonUtil.GsonString(GsonUtil.readerJsonObject("json/executeCase/update.json")))
                .accept(MediaType.APPLICATION_JSON)).andExpect(result -> {
            logger.info(" 返回报文 -> " + result.getResponse().getContentAsString());
        });

    }

    @Test
    public void delete() throws Exception {

        mockMvc.perform(post("/executeCase/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content(GsonUtil.GsonString(GsonUtil.readerJsonObject("json/executeCase/delete.json")))
                .accept(MediaType.APPLICATION_JSON)).andExpect(result -> {
            logger.info(" 返回报文 -> " + result.getResponse().getContentAsString());
        });

    }
}
