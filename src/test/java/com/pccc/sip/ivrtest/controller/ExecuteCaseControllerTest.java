package com.pccc.sip.ivrtest.controller;

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
public class ExecuteCaseControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(ExecuteCaseControllerTest.class);

    @Autowired
    MockMvc mockMvc;

    @Test
    public void executeCases() throws Exception {

        mockMvc.perform(post("/executeCase/execute")
        .contentType(MediaType.APPLICATION_JSON)
        .content("[\n" +
                "    {\n" +
                "        \"id\": \"IVRE202202110002\",\n" +
                "        \"caseId\": \"IVRT2204020001\",\n" +
                "        \"executeId\": \"IVRE202202110001\",\n" +
                "        \"used\": \"1\",\n" +
                "        \"variableData\": {\n" +
                "            \"AccNo\": \"62222222555|65555232322222\",\n" +
                "            \"PassWord\": \"111111|222222|333333\",\n" +
                "            \"Asr\": \"查询账单|查询额度\",\n" +
                "            \"FlowCode\": \"flowcode_10008\",\n" +
                "            \"balance\": \"100\",\n" +
                "            \"debt\": \"1000\"\n" +
                "        }\n" +
                "    }\n" +
                "]")
        .accept(MediaType.APPLICATION_JSON)).andExpect(result -> {
            logger.info(" 返回报文 -> " + result.getResponse().getContentAsString());
        });

    }

}
