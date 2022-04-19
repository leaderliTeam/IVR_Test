package com.pccc.sip.ivrtest.controller;

import com.pccc.sip.ivrtest.constant.Type;
import com.pccc.sip.ivrtest.engine.EngineRedisQueue;
import com.pccc.sip.ivrtest.entity.*;
import com.pccc.sip.ivrtest.service.CommonService;
import com.pccc.sip.ivrtest.service.ExecuteCaseService;
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
    private ExecuteCaseService executeCaseService;
    @Autowired
    private CommonService commonService;

    @PostMapping("/execute")
    public ExecuteCaseResponse executeCases(@RequestBody List<ExecuteCaseEntity> executeCaseEntities){
        int size = engineRedisQueue.put(executeCaseEntities);
        ExecuteCaseResponse executeCaseResponse = new ExecuteCaseResponse();
        executeCaseResponse.setSize(size);
        return executeCaseResponse;
    }

    @PostMapping("/addData")
    public BaseResponse addData(@RequestBody FillDataRequest fillDataRequest){
        boolean flag = executeCaseService.addBatchExecCase(fillDataRequest);
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

    @PostMapping("/add")
    public BaseResponse addExecuteCase(@RequestBody ExecuteCaseEntity executeCaseEntity){
        int res = executeCaseService.addExecCase(executeCaseEntity);
        BaseResponse baseResponse = new BaseResponse();
        if (res == 0){
            baseResponse.setReturnMsg(Type.FAIL);
        }
        return baseResponse;
    }

    @PostMapping("/query")
    public QueryExecCasePageResponse queryExecuteCaseByPage(@RequestBody QueryExecCasePageRequest request){
        return executeCaseService.queryByPage(request);
    }

    @PostMapping("/update")
    public BaseResponse updateExecuteCase(@RequestBody ExecuteCaseEntity executeCaseEntity){
        int res = executeCaseService.updateById(executeCaseEntity);
        BaseResponse baseResponse = new BaseResponse();
        if (res == 0){
            baseResponse.setReturnMsg(Type.FAIL);
        }
        return baseResponse;
    }

    @PostMapping("/delete")
    public BaseResponse deleteExecuteCase(@RequestBody DeleteExecCaseRequest deleteExecCaseRequest){
        int res = executeCaseService.deleteBatchIds(deleteExecCaseRequest.getId());
        BaseResponse baseResponse = new BaseResponse();
        if (res == 0){
            baseResponse.setReturnMsg(Type.FAIL);
        }
        return baseResponse;
    }
}
