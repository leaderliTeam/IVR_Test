package com.pccc.sip.ivrtest.controller;

import com.pccc.sip.ivrtest.entity.BaseResponse;
import com.pccc.sip.ivrtest.pojo.TestCase;
import com.pccc.sip.ivrtest.service.TestCaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testCase")
public class TestCaseController {
    @Autowired
    private TestCaseService testCaseService;

    BaseResponse response = new BaseResponse();

    //增
    @PostMapping(value = "/add")
    public Object add(@RequestBody TestCase testCase) {
        if (StringUtils.equals(String.valueOf(testCaseService.addTestCase(testCase)), "1")) {
            return response;
        } else {
            response.setCode(-1);
            response.setMsg("fail");
            return response;
        }
    }

    //改
    @PostMapping(value = "/update")
    public Object update(@RequestBody TestCase testCase) {
        if (StringUtils.equals(String.valueOf(testCaseService.updateTestCase(testCase)), "1")) {
            return response;
        } else {
            response.setCode(-1);
            response.setMsg("fail");
            return response;
        }
    }

    //删
    @PostMapping(value = "/delete")
    public Object delete(@RequestBody TestCase testCase) {
        if (StringUtils.equals(String.valueOf(testCaseService.deleteTestCaseById(testCase.getId())), "1")) {
            return response;
        } else {
            response.setCode(-1);
            response.setMsg("fail");
            return response;
        }
    }

    // 查
    @PostMapping(value = "/queryList")
    public TestCase getUserByName(@RequestBody TestCase testCase) {
        return testCaseService.findTestCaseById(testCase.getId());
    }
}
