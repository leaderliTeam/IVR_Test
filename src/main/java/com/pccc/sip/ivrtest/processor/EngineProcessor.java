package com.pccc.sip.ivrtest.processor;

import com.pccc.sip.ivrtest.engine.EngineQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EngineProcessor {

    @Autowired
    EngineQueue engineQueue;

    @PostConstruct
    public void init(){
        while (true){
            if (!engineQueue.checkQueue()){
                System.out.println("+++++++"+System.currentTimeMillis());
                engineQueue.poll();
            }
        }
    }

}
