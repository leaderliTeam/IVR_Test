package com.pccc.sip.ivrtest.controller;

import com.pccc.sip.ivrtest.constant.Type;
import com.pccc.sip.ivrtest.entity.response.BaseResponse;
import com.pccc.sip.ivrtest.pojo.DeleteTestCaseRequest;
import com.pccc.sip.ivrtest.pojo.TestTag;
import com.pccc.sip.ivrtest.service.TestTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanghao
 * @date 2022/4/20 14:12
 */
@RestController
@RequestMapping("/labal")
public class TestTagController {
    @Autowired
    private TestTagService testTagService;

    BaseResponse response = new BaseResponse();

    @PostMapping(value = "/add")
    public Object add(@RequestBody TestTag testTag) {
        if (testTagService.addTestTag(testTag) == 1) {
            return response;
        } else {
            response.setReturnMsg(Type.FAIL);
            return response;
        }
    }

    //改
    @PostMapping(value = "/update")
    public Object update(@RequestBody TestTag testTag) {
        if (testTagService.updateTestTag(testTag) == 1) {
            return response;
        } else {
            response.setReturnMsg(Type.FAIL);
            return response;
        }
    }

    //删
    @PostMapping(value = "/delete")
    public Object delete(@RequestBody DeleteTestCaseRequest deleteTestCaseRequest) {
        if (testTagService.deleteTestTagById(deleteTestCaseRequest.getId()) == 0) {
            response.setReturnMsg(Type.FAIL);
            return response;
        } else {
            return response;
        }
    }

    // 查
    @PostMapping(value = "/queryList")
    public TestTag getUserByName(@RequestBody TestTag testTag) {
        return testTagService.findTestTagById(testTag.getTestCaseId());
    }
}
