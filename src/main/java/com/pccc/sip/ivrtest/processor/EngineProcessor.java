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
        new Thread(()->{
            while (true){
                System.out.println("-------"+System.currentTimeMillis());
                if (!engineQueue.checkQueue()){
                    System.out.println("+++++++"+System.currentTimeMillis());
                    engineQueue.poll();
                }
            }
        }).start();
    }

}
