package com.pccc.sip.ivrtest.controller;

import com.pccc.sip.ivrtest.engine.EngineRedisQueue;
import com.pccc.sip.ivrtest.entity.ExecuteCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/executeCase")
public class ExecuteCaseController {

    @Autowired
    private EngineRedisQueue engineQueue;

    @PostMapping("/execute")
    public int executeCases(@RequestBody List<ExecuteCase> executeCases){
        engineQueue.put(executeCases);
        return executeCases.size();
    }

}
