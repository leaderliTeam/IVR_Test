package com.pccc.sip.ivrtest.controller;

import com.pccc.sip.ivrtest.constant.Type;
import com.pccc.sip.ivrtest.entity.response.BaseResponse;
import com.pccc.sip.ivrtest.pojo.DeleteTestCaseRequest;
import com.pccc.sip.ivrtest.pojo.TestCase;
import com.pccc.sip.ivrtest.service.TestCaseService;
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
        if (testCaseService.addTestCase(testCase) == 1) {
            return response;
        } else {
            response.setReturnMsg(Type.FAIL);
            return response;
        }
    }

    //改
    @PostMapping(value = "/update")
    public Object update(@RequestBody TestCase testCase) {
        if (testCaseService.updateTestCase(testCase) == 1) {
            return response;
        } else {
            response.setReturnMsg(Type.FAIL);
            return response;
        }
    }

    //删
    @PostMapping(value = "/delete")
    public Object delete(@RequestBody DeleteTestCaseRequest deleteTestCaseRequest) {
        if (testCaseService.deleteTestCaseById(deleteTestCaseRequest.getId()) == 0) {
            response.setReturnMsg(Type.FAIL);
            return response;
        } else {
            return response;
        }
    }

    // 查
    @PostMapping(value = "/queryList")
    public TestCase getUserByName(@RequestBody TestCase testCase) {
        return testCaseService.findTestCaseById(testCase.getId());
    }
}
