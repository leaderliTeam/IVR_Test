package com.pccc.sip.ivrtest.service.impl;

import com.pccc.sip.ivrtest.mapper.ExecCaseMapper;
import com.pccc.sip.ivrtest.mapper.ExecCaseResultMapper;
import com.pccc.sip.ivrtest.mapper.TestCaseMapper;
import com.pccc.sip.ivrtest.pojo.ExecCase;
import com.pccc.sip.ivrtest.service.ExecuteEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExecuteEngineServiceImpl implements ExecuteEngineService {

    @Autowired
    private ExecCaseMapper execCaseMapper;
    @Autowired
    private ExecCaseResultMapper execCaseResultMapper;
    @Autowired
    private TestCaseMapper testCaseMapper;


    @Override
    public ExecCase queryExecCaseById(String id) {
        return execCaseMapper.queryById(id);
    }
}
