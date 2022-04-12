package com.pccc.sip.ivrtest.engine;

import com.pccc.sip.ivrtest.entity.ExecuteCaseRequest;
import com.pccc.sip.ivrtest.mapper.ExecCaseMapper;
import com.pccc.sip.ivrtest.mapper.ExecCaseResultMapper;
import com.pccc.sip.ivrtest.mapper.TestCaseMapper;
import com.pccc.sip.ivrtest.pojo.ExecCase;
import com.pccc.sip.ivrtest.service.ExecuteEngineService;
import io.leaderli.litil.meta.Lino;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExecuteEngine {

    private static final Logger logger = LoggerFactory.getLogger(ExecuteEngine.class);

    @Autowired
    private ExecuteEngineService executeEngineService;

    public void executeCases(ExecuteCaseRequest executeCaseRequest){
        logger.info(executeCaseRequest.getId());
        ExecCase execCase = executeEngineService.queryExecCaseById(executeCaseRequest.getId());
        logger.info(Lino.of(execCase).map(ExecCase::toString).get());
    }

}
