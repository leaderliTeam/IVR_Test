package com.pccc.sip.ivrtest.processor;

import com.pccc.sip.ivrtest.engine.EngineRedisQueue;
import com.pccc.sip.ivrtest.engine.ExecuteEngine;
import io.leaderli.litil.meta.Lino;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EngineProcessor implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger logger = LoggerFactory.getLogger(EngineProcessor.class);
    @Autowired
    private EngineRedisQueue engineRedisQueue;
    @Autowired
    private ExecuteEngine executeEngine;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        new Thread(() -> {
            while (true) {
                if (engineRedisQueue.exists() && engineRedisQueue.size() > 0 ) {
                    try{
                        executeEngine.executeCases(Lino.of(engineRedisQueue).map(EngineRedisQueue::pop).get());
                    }catch (Exception e){
                        logger.error(" engineProcessor error ", e);
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    logger.error(" engineProcessor sleep error ", e);
                }
            }
        }).start();
    }
}
