package com.pccc.sip.ivrtest.engine;

import com.pccc.sip.ivrtest.entity.ExecuteCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class EngineQueue {

    private static final Logger logger = LoggerFactory.getLogger(EngineQueue.class);

    private static final BlockingQueue<ExecuteCase> queue = new LinkedBlockingQueue<>();

    public void put(List<ExecuteCase> executeCases) {
        executeCases.forEach(executeCase -> {
            try {
                queue.put(executeCase);
            } catch (InterruptedException e) {
                logger.error(" engineQueue error -> ",e);
            }
        });
    }

    public ExecuteCase poll() {
        return queue.poll();
    }

    public boolean checkQueue() {
        return queue.isEmpty();
    }

    public int size(){
        return queue.size();
    }
}
