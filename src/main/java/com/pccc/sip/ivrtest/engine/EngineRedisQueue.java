package com.pccc.sip.ivrtest.engine;

import com.pccc.sip.ivrtest.config.JedisTemplate;
import com.pccc.sip.ivrtest.entity.ExecuteCaseRequest;
import com.pccc.sip.ivrtest.util.GsonUtil;
import io.leaderli.litil.meta.Lino;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EngineRedisQueue {

    private static final Logger logger = LoggerFactory.getLogger(EngineRedisQueue.class);

    private static final String EXECUTE_CASES_KEY = "execute_cases";

    @Autowired
    private JedisTemplate jedisTemplate;

    public void put(List<ExecuteCaseRequest> executeCaseRequests) {
        Lino.of(executeCaseRequests).get().forEach(executeCaseRequest -> {
            jedisTemplate.lpush(EXECUTE_CASES_KEY, GsonUtil.GsonString(executeCaseRequest));
        });
    }

    public ExecuteCaseRequest poll() {
        return GsonUtil.GsonToBean(jedisTemplate.rpop(EXECUTE_CASES_KEY), ExecuteCaseRequest.class);
    }

    public boolean exists() {
        return jedisTemplate.exists(EXECUTE_CASES_KEY);
    }

    public Long size() {
        return jedisTemplate.llen(EXECUTE_CASES_KEY);
    }

}
