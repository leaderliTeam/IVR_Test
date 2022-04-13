package com.pccc.sip.ivrtest.service.impl;

import com.pccc.sip.ivrtest.mapper.ExecCaseMapper;
import com.pccc.sip.ivrtest.mapper.ExecCaseResultMapper;
import com.pccc.sip.ivrtest.mapper.TestCaseMapper;
import com.pccc.sip.ivrtest.pojo.ExecCase;
import com.pccc.sip.ivrtest.pojo.ExecCaseResult;
import com.pccc.sip.ivrtest.pojo.TestCase;
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

    @Override
    public int modifyExecCaseById(ExecCase execCase) {
        return execCaseMapper.updateById(execCase);
    }

    @Override
    public TestCase queryTestCaseById(String id) {
        return testCaseMapper.selectById(id);
    }

    @Override
    public int modifyTestCaseById(TestCase execCase) {
        return testCaseMapper.updateById(execCase);
    }

    @Override
    public void modifyCaseById(TestCase testCase, ExecCase execCase) {
        testCaseMapper.updateTestCaseById(testCase);
        execCaseMapper.updateExecCaseById(execCase);
    }

    @Override
    public int addExecCaseResult(ExecCaseResult execCaseResult) {
         return execCaseResultMapper.insert(execCaseResult);
    }
}
