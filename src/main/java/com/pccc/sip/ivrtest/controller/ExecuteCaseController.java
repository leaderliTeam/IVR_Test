package com.pccc.sip.ivrtest.controller;

import com.pccc.sip.ivrtest.engine.EngineRedisQueue;
import com.pccc.sip.ivrtest.entity.ExecuteCaseRequest;
import com.pccc.sip.ivrtest.entity.ExecuteCaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/executeCase")
public class ExecuteCaseController {

    @Autowired
    private EngineRedisQueue engineRedisQueue;

    @PostMapping("/execute")
    public ExecuteCaseResponse executeCases(@RequestBody List<ExecuteCaseRequest> executeCaseRequests){
        engineRedisQueue.put(executeCaseRequests);
        ExecuteCaseResponse executeCaseResponse = new ExecuteCaseResponse();
        executeCaseResponse.setSize(executeCaseRequests.size());
        return executeCaseResponse;
    }

}
