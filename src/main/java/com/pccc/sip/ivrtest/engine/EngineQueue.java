package com.pccc.sip.ivrtest.engine;

import com.pccc.sip.ivrtest.entity.ExecuteCase;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class EngineQueue {

    private static BlockingQueue<ExecuteCase> queue = new LinkedBlockingQueue<>();

    public void put(ExecuteCase executeCase) {
        try {
            queue.put(executeCase);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ExecuteCase poll() {
        return queue.poll() == null ? null : queue.poll();
    }

    public boolean checkQueue() {
        return queue.isEmpty();
    }

}
