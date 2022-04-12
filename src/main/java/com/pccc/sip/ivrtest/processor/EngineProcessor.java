package com.pccc.sip.ivrtest.processor;

import com.pccc.sip.ivrtest.engine.EngineQueue;
import com.pccc.sip.ivrtest.engine.ExecuteEngine;
import com.pccc.sip.ivrtest.entity.ExecuteCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EngineProcessor {

    @Autowired
    private EngineQueue engineQueue;
    @Autowired
    private ExecuteEngine executeEngine;

    @PostConstruct
    public void init() {
        new Thread(() -> {
            while (true) {
                if (!engineQueue.checkQueue()) {
                    ExecuteCase executeCase = engineQueue.poll();
                    executeEngine.executeCases(executeCase);
                }
            }
        }).start();
    }

}
