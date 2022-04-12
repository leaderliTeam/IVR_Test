package com.pccc.sip.ivrtest.controller;

import com.pccc.sip.ivrtest.pojo.TestCase;
import com.pccc.sip.ivrtest.service.TestCaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/testCase")
public class TestCaseController {
    @Autowired
    private TestCaseService testCaseService;

    //增
    @PostMapping(value = "/add")
    public Object add(@RequestBody TestCase testCase) {
        Map map = new HashMap();
        if (StringUtils.equals(String.valueOf(testCaseService.addTestCase(testCase)), "1")) {
            map.put("code", "0");
            map.put("msg", "success");
            return map;
        } else {
            map.put("code", "-1");
            map.put("msg", "fail");
            return map;
        }
    }

    //改
    @PostMapping(value = "/update")
    public Object update(@RequestBody TestCase testCase) {
        Map map = new HashMap();
        if (StringUtils.equals(String.valueOf(testCaseService.updateTestCase(testCase)), "1")) {
            map.put("code", "0");
            map.put("msg", "success");
            return map;
        } else {
            map.put("code", "-1");
            map.put("msg", "fail");
            return map;
        }
    }

    //删
    @PostMapping(value = "/delete")
    public Object delete(@RequestBody String id) {
        return testCaseService.deleteTestCaseById(id);
    }

    // 查
    @PostMapping(value = "/queryList")
    public Object getUserByName(@RequestBody String id) {
        return testCaseService.findTestCaseById(id);
    }
}
