package com.pccc.sip.ivrtest.controller;

import com.pccc.sip.ivrtest.entity.response.BaseResponse;
import com.pccc.sip.ivrtest.pojo.ExpResultRule;
import com.pccc.sip.ivrtest.service.ExpResultRuleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expResultRule")
public class ExpResultRuleController {
    @Autowired
    private ExpResultRuleService expResultRuleService;

    BaseResponse response = new BaseResponse();

    //增
    @PostMapping(value = "/add")
    public Object add(@RequestBody ExpResultRule expResultRule) {
        if (StringUtils.equals(String.valueOf(expResultRuleService.addExpResultRule(expResultRule)), "1")) {
            return response;
        } else {
            response.setCode(-1);
            response.setMsg("fail");
            return response;
        }
    }

    //改
    @PostMapping(value = "/update")
    public Object update(@RequestBody ExpResultRule expResultRule) {
        if (StringUtils.equals(String.valueOf(expResultRuleService.updateExpResultRule(expResultRule)), "1")) {
            return response;
        } else {
            response.setCode(-1);
            response.setMsg("fail");
            return response;
        }
    }

    //删
    @PostMapping(value = "/delete")
    public Object delete(@RequestBody ExpResultRule expResultRule) {
        if (StringUtils.equals(String.valueOf(expResultRuleService.deleteExpResultRuleById(expResultRule.getTestCaseId())), "1")) {
            return response;
        } else {
            response.setCode(-1);
            response.setMsg("fail");
            return response;
        }
    }

    // 查
    @PostMapping(value = "/queryList")
    public ExpResultRule getUserByName(@RequestBody ExpResultRule expResultRule) {
        return expResultRuleService.findExpResultRuleById(expResultRule.getTestCaseId());
    }

}
