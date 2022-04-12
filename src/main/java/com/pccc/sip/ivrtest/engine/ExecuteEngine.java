package com.pccc.sip.ivrtest.engine;

import com.pccc.sip.ivrtest.entity.ExecuteCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ExecuteEngine {

    private static final Logger logger = LoggerFactory.getLogger(ExecuteEngine.class);

    public void executeCases(ExecuteCase executeCase){
        logger.info(executeCase.getId());
    }

}
