package com.pccc.sip.ivrtest.controller;

import com.pccc.sip.ivrtest.constant.Type;
import com.pccc.sip.ivrtest.engine.EngineRedisQueue;
import com.pccc.sip.ivrtest.entity.BaseResponse;
import com.pccc.sip.ivrtest.entity.ExecuteCaseRequest;
import com.pccc.sip.ivrtest.entity.ExecuteCaseResponse;
import com.pccc.sip.ivrtest.entity.FillDataRequest;
import com.pccc.sip.ivrtest.service.CommonService;
import com.pccc.sip.ivrtest.service.ExecuteEngineService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/executeCase")
public class ExecuteCaseController {

    @Autowired
    private EngineRedisQueue engineRedisQueue;
    @Autowired
    private ExecuteEngineService executeEngineService;
    @Autowired
    private CommonService commonService;

    @PostMapping("/execute")
    public ExecuteCaseResponse executeCases(@RequestBody List<ExecuteCaseRequest> executeCaseRequests){
        int size = engineRedisQueue.put(executeCaseRequests);
        ExecuteCaseResponse executeCaseResponse = new ExecuteCaseResponse();
        executeCaseResponse.setSize(size);
        return executeCaseResponse;
    }

    @PostMapping("/addData")
    public BaseResponse addData(@RequestBody FillDataRequest fillDataRequest){
        boolean flag = executeEngineService.addBatchExecCase(fillDataRequest);
        BaseResponse baseResponse = new BaseResponse();
        if (!flag){
            baseResponse.setReturnMsg(Type.FAIL);
        }
        return baseResponse;
    }

    @GetMapping("/queryId")
    public ExecuteCaseResponse queryCaseId(@RequestParam(value = "queryType") String queryType){
        ExecuteCaseResponse executeCaseResponse = new ExecuteCaseResponse();
        if (!StringUtils.equalsAny(queryType,Type.EXECCASE.getType(),Type.TESTCASE.getType())){
            executeCaseResponse.setReturnMsg(Type.FAIL);
            executeCaseResponse.setMsg("查询类型有误，请检查");
        }else {
            String id = commonService.getTodayCaseIdOfNew(queryType);
            executeCaseResponse.setId(id);
        }
        return executeCaseResponse;
    }

}
